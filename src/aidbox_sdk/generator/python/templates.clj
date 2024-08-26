(ns aidbox-sdk.generator.python.templates)

(def setup
  "from setuptools import setup

setup(
    name=\"aidbox\",
    version=\"0.0.1\",
    description=\"\",
    python_requires=\">=3.7\",
    package_data={\"\": [\"py.typed\"]},
    include_package_data=True,
    install_requires=[
        \"requests>=2.31.0\",
        \"types-requests==2.31.0.8\",
        \"pydantic[email]==2.0.0\",
        \"pydantic_core==2.0.1\",
    ],
    classifiers=[
        \"License :: OSI Approved :: MIT License\",
        \"Operating System :: OS Independent\",
        \"Development Status :: 2 - Pre-Alpha\",
        \"Programming Language :: Python\",
        \"Programming Language :: Python :: 3\",
        \"Intended Audience :: Developers\",
        \"License :: OSI Approved :: MIT License\",
        \"Typing :: Typed\",
    ],
)
")

(def base
  "from __future__ import annotations
from typing_extensions import TypeAlias

IncEx: TypeAlias = \"set[int] | set[str] | dict[int, Any] | dict[str, Any] | None\"
from typing import Literal, Union, Literal, Mapping, Optional, List, Any, overload
from pydantic import BaseModel, EmailStr, Field, PositiveInt, NonNegativeInt

import os

import requests
from requests.auth import HTTPBasicAuth

username = os.environ.get(\"AIDBOX_CLIENT_USERNAME\")
password = os.environ.get(\"AIDBOX_CLIENT_PASSWORD\")

if username is None:
    raise Exception(\"AIDBOX_CLIENT_USERNAME environment variable is missing\")
if password is None:
    raise Exception(\"AIDBOX_CLIENT_PASSWORD environment variable is missing\")

base = os.environ.get(\"AIDBOX_URL\")
basic = HTTPBasicAuth(username, password)


class API(BaseModel):
    @classmethod
    def from_id(cls, id: str):
        response = requests.get(url=f\"{base}/fhir/{cls.__name__}/{id}\", auth=basic)
        response.raise_for_status()  # TODO: handle and type HTTP codes except 200+
        return cls(**response.json())

    @classmethod
    def bundle(cls, entry: list[Any], type: Literal[\"transaction\"]):
        data = {\"resourceType\": \"Bundle\", \"type\": type, \"entry\": entry}
        response = requests.post(url=f\"{base}/fhir\", json=data, auth=basic)
        response.raise_for_status()  # TODO: handle and type HTTP codes except 200+

    @classmethod
    def get(cls, *args: dict[str, Any]):
        search_params: dict[str, Any] = {}
        [search_params.update(d) for d in args]
        response = requests.get(
            url=f\"{base}/fhir/{cls.__name__}\", params=search_params, auth=basic
        )
        response.raise_for_status()  # TODO: handle and type HTTP codes except 200+
        data = response.json()  # TODO: handle HTTP response bodies
        return (
            list(map(lambda patient: cls(**patient[\"resource\"]), data[\"entry\"]))
            if \"entry\" in data
            else []
        )

    def delete(self):
        assert self.id is not None
        resource_type = self.__class__.__name__
        response = requests.delete(
            url=f\"{base}/fhir/{resource_type}/{self.id}\", auth=basic
        )
        response.raise_for_status()  # TODO: handle and type HTTP codes except 200+

    def save(self):  # create | persist | save
        resource_type = self.__class__.__name__
        response = requests.put(
            url=f\"{base}/fhir/{resource_type}/{self.id or ''}\",
            json=self.dumps(exclude_unset=True),
            auth=basic,
        )
        response.raise_for_status()  # TODO: handle and type HTTP codes except 200+
        data = response.json()
        self.id = data[\"id\"]
        self.meta = Meta(**data[\"meta\"])

    def dumps(
        self,
        *,
        mode: Literal[\"json\", \"python\"] | str = \"python\",
        include: IncEx = None,
        exclude: IncEx = None,
        by_alias: bool = False,
        exclude_unset: bool = False,
        exclude_defaults: bool = False,
        exclude_none: bool = False,
        round_trip: bool = False,
        warnings: bool = True,
        ):
        data = self.model_dump(
            mode=mode,
            by_alias=by_alias,
            include=include,
            exclude=exclude,
            exclude_unset=exclude_unset,
            exclude_defaults=exclude_defaults,
            exclude_none=exclude_none,
            round_trip=round_trip,
            warnings=warnings,
        )

        for item in [\"class\", \"global\", \"for\", \"import\"]:
            if (item + \"_\") in data:
                data[item] = data[item + \"_\"]
                del data[item + \"_\"]

        return data

    @classmethod
    def make_request(cls, endpoint, method=\"GET\", **kwargs):
        url = f\"{base}{endpoint}\"
        return requests.request(method, url, auth=basic, **kwargs)")

(def files
  [{:path "setup.py"
    :content setup}
   {:path "aidbox/py.typed"
    :contet ""}
   {:path "aidbox/__init__.py"
    :contet ""}
   {:path "aidbox/__init__.py"
    :content ""}
   {:path "aidbox/base/__init__.py"
    :content base}])
