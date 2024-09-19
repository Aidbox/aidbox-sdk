"""
setup.py
"""

from setuptools import setup

setup(
    name="aidbox",
    version="0.0.1",
    description="",
    python_requires=">=3.8",
    package_data={"": ["py.typed"]},
    include_package_data=True,
    install_requires=[
        "requests>=2.31.0",
        "types-requests==2.31.0.8",
        "pydantic[email]==2.9.2",
        # "pydantic_core==2.24.0",
    ],
    extras_require={
        'dev': [
            'pylint'
        ],
    },
    classifiers=[
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
        "Development Status :: 2 - Pre-Alpha",
        "Programming Language :: Python",
        "Programming Language :: Python :: 3",
        "Intended Audience :: Developers",
        "License :: OSI Approved :: MIT License",
        "Typing :: Typed",
    ],
)
