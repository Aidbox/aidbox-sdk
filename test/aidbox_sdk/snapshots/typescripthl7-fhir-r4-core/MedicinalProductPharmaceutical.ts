import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { Duration } from "./Duration";
import { DomainResource } from "./DomainResource";
import { Ratio } from "./Ratio";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MedicinalProductPharmaceuticalCharacteristics = BackboneElement & {
    code: CodeableConcept;
    status?: CodeableConcept;
};

export type MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriod = BackboneElement & {
    value: Quantity;
    tissue: CodeableConcept;
    supportingInformation?: string;
};

export type MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpecies = BackboneElement & {
    code: CodeableConcept;
    withdrawalPeriod?: MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriod[];
};

export type MedicinalProductPharmaceuticalRouteOfAdministration = BackboneElement & {
    code: CodeableConcept;
    firstDose?: Quantity;
    maxDosePerDay?: Quantity;
    maxSingleDose?: Quantity;
    targetSpecies?: MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpecies[];
    maxTreatmentPeriod?: Duration;
    maxDosePerTreatmentPeriod?: Ratio;
};

export type MedicinalProductPharmaceutical = DomainResource & {
    device?: Reference[];
    identifier?: Identifier[];
    ingredient?: Reference[];
    characteristics?: MedicinalProductPharmaceuticalCharacteristics[];
    unitOfPresentation?: CodeableConcept;
    administrableDoseForm: CodeableConcept;
    routeOfAdministration: MedicinalProductPharmaceuticalRouteOfAdministration[];
};