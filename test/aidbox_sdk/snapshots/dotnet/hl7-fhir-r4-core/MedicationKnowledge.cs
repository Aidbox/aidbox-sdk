using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicationKnowledge : DomainResource, IResource
{
    public string? PreparationInstruction { get; set; }
    public Base.Quantity? Amount { get; set; }
    public MedicationKnowledge_Monograph[]? Monograph { get; set; }
    public MedicationKnowledge_Regulatory[]? Regulatory { get; set; }
    public Base.CodeableConcept? DoseForm { get; set; }
    public Base.CodeableConcept[]? IntendedRoute { get; set; }
    public MedicationKnowledge_DrugCharacteristic[]? DrugCharacteristic { get; set; }
    public MedicationKnowledge_Packaging? Packaging { get; set; }
    public MedicationKnowledge_RelatedMedicationKnowledge[]? RelatedMedicationKnowledge { get; set; }
    public MedicationKnowledge_MedicineClassification[]? MedicineClassification { get; set; }
    public MedicationKnowledge_Kinetics[]? Kinetics { get; set; }
    public Base.ResourceReference[]? AssociatedMedication { get; set; }
    public MedicationKnowledge_Ingredient[]? Ingredient { get; set; }
    public MedicationKnowledge_MonitoringProgram[]? MonitoringProgram { get; set; }
    public Base.ResourceReference[]? Contraindication { get; set; }
    public string? Status { get; set; }
    public Base.CodeableConcept[]? ProductType { get; set; }
    public string[]? Synonym { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public MedicationKnowledge_AdministrationGuidelines[]? AdministrationGuidelines { get; set; }
    public Base.ResourceReference? Manufacturer { get; set; }
    public MedicationKnowledge_Cost[]? Cost { get; set; }

    public class MedicationKnowledge_Monograph : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference? Source { get; set; }
    }

    public class MedicationKnowledge_Regulatory_Schedule : BackboneElement
    {
        public required Base.CodeableConcept Schedule { get; set; }
    }

    public class MedicationKnowledge_Regulatory_MaxDispense : BackboneElement
    {
        public string? Period { get; set; }
        public required Base.Quantity Quantity { get; set; }
    }

    public class MedicationKnowledge_Regulatory_Substitution : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public required bool Allowed { get; set; }
    }

    public class MedicationKnowledge_Regulatory : BackboneElement
    {
        public MedicationKnowledge_Regulatory_Schedule[]? Schedule { get; set; }
        public MedicationKnowledge_Regulatory_MaxDispense? MaxDispense { get; set; }
        public MedicationKnowledge_Regulatory_Substitution[]? Substitution { get; set; }
        public required Base.ResourceReference RegulatoryAuthority { get; set; }
    }

    public class MedicationKnowledge_DrugCharacteristic : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueBase64Binary is not null)
                {
                    return ValueBase64Binary;
                }
        
                if (ValueCodeableConcept is not null)
                {
                    return ValueCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueBase64Binary = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ValueCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueString { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public string? ValueBase64Binary { get; set; }
        public Base.CodeableConcept? ValueCodeableConcept { get; set; }
    }

    public class MedicationKnowledge_Packaging : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.Quantity? Quantity { get; set; }
    }

    public class MedicationKnowledge_RelatedMedicationKnowledge : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public required Base.ResourceReference[] Reference { get; set; }
    }

    public class MedicationKnowledge_MedicineClassification : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public Base.CodeableConcept[]? Classification { get; set; }
    }

    public class MedicationKnowledge_Kinetics : BackboneElement
    {
        public Base.Quantity[]? LethalDose50 { get; set; }
        public Base.Quantity[]? AreaUnderCurve { get; set; }
        public string? HalfLifePeriod { get; set; }
    }

    public class MedicationKnowledge_Ingredient : BackboneElement
    {
        public object? Item    
        {
            get
            {
                if (ItemReference is not null)
                {
                    return ItemReference;
                }
        
                if (ItemCodeableConcept is not null)
                {
                    return ItemCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ItemReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ItemCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public bool? IsActive { get; set; }
        public Base.Ratio? Strength { get; set; }
        public Base.ResourceReference? ItemReference { get; set; }
        public Base.CodeableConcept? ItemCodeableConcept { get; set; }
    }

    public class MedicationKnowledge_MonitoringProgram : BackboneElement
    {
        public string? Name { get; set; }
        public Base.CodeableConcept? Type { get; set; }
    }

    public class MedicationKnowledge_AdministrationGuidelines_Dosage : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public required string[] Dosage { get; set; }
    }

    public class MedicationKnowledge_AdministrationGuidelines_PatientCharacteristics : BackboneElement
    {
        public string[]? Value { get; set; }
        public object? Characteristic    
        {
            get
            {
                if (CharacteristicQuantity is not null)
                {
                    return CharacteristicQuantity;
                }
        
                if (CharacteristicCodeableConcept is not null)
                {
                    return CharacteristicCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    CharacteristicQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    CharacteristicCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Quantity? CharacteristicQuantity { get; set; }
        public Base.CodeableConcept? CharacteristicCodeableConcept { get; set; }
    }

    public class MedicationKnowledge_AdministrationGuidelines : BackboneElement
    {
        public MedicationKnowledge_AdministrationGuidelines_Dosage[]? Dosage { get; set; }
        public object? Indication    
        {
            get
            {
                if (IndicationReference is not null)
                {
                    return IndicationReference;
                }
        
                if (IndicationCodeableConcept is not null)
                {
                    return IndicationCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    IndicationReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    IndicationCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? IndicationReference { get; set; }
        public MedicationKnowledge_AdministrationGuidelines_PatientCharacteristics[]? PatientCharacteristics { get; set; }
        public Base.CodeableConcept? IndicationCodeableConcept { get; set; }
    }

    public class MedicationKnowledge_Cost : BackboneElement
    {
        public required Base.Money Cost { get; set; }
        public required Base.CodeableConcept Type { get; set; }
        public string? Source { get; set; }
    }
}