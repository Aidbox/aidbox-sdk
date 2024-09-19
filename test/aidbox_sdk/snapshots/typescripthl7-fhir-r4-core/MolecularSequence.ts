import { CodeableConcept } from "./CodeableConcept";
import { Quantity } from "./Quantity";
import { DomainResource } from "./DomainResource";
import { Reference } from "./Reference";
import { Identifier } from "./Identifier";
import { BackboneElement } from "./BackboneElement";

export type MolecularSequenceStructureVariantInner = BackboneElement & {
    end?: number;
    start?: number;
};

export type MolecularSequenceStructureVariantOuter = BackboneElement & {
    end?: number;
    start?: number;
};

export type MolecularSequenceStructureVariant = BackboneElement & {
    exact?: boolean;
    inner?: MolecularSequenceStructureVariantInner;
    outer?: MolecularSequenceStructureVariantOuter;
    length?: number;
    variantType?: CodeableConcept;
};

export type MolecularSequenceRepository = BackboneElement & {
    url?: string;
    name?: string;
    type: string;
    datasetId?: string;
    readsetId?: string;
    variantsetId?: string;
};

export type MolecularSequenceVariant = BackboneElement & {
    end?: number;
    cigar?: string;
    start?: number;
    observedAllele?: string;
    variantPointer?: Reference;
    referenceAllele?: string;
};

export type MolecularSequenceQualityRoc = BackboneElement & {
    numFN?: number[];
    numFP?: number[];
    numTP?: number[];
    score?: number[];
    fMeasure?: number[];
    precision?: number[];
    sensitivity?: number[];
};

export type MolecularSequenceQuality = BackboneElement & {
    truthTP?: number;
    fScore?: number;
    truthFN?: number;
    queryFP?: number;
    method?: CodeableConcept;
    precision?: number;
    start?: number;
    queryTP?: number;
    type: string;
    recall?: number;
    roc?: MolecularSequenceQualityRoc;
    score?: Quantity;
    end?: number;
    standardSequence?: CodeableConcept;
    gtFP?: number;
};

export type MolecularSequenceReferenceSeq = BackboneElement & {
    chromosome?: CodeableConcept;
    referenceSeqId?: CodeableConcept;
    windowEnd?: number;
    strand?: string;
    genomeBuild?: string;
    orientation?: string;
    referenceSeqPointer?: Reference;
    referenceSeqString?: string;
    windowStart?: number;
};

export type MolecularSequence = DomainResource & {
    patient?: Reference;
    structureVariant?: MolecularSequenceStructureVariant[];
    repository?: MolecularSequenceRepository[];
    variant?: MolecularSequenceVariant[];
    specimen?: Reference;
    type?: string;
    pointer?: Reference[];
    observedSeq?: string;
    identifier?: Identifier[];
    quality?: MolecularSequenceQuality[];
    device?: Reference;
    quantity?: Quantity;
    coordinateSystem: number;
    referenceSeq?: MolecularSequenceReferenceSeq;
    performer?: Reference;
    readCoverage?: number;
};