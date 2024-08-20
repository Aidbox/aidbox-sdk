using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class SpecimenDefinition : DomainResource, IResource
{
    public Base.CodeableConcept[]? Collection { get; set; }
    public Base.Identifier? Identifier { get; set; }
    public string? TimeAspect { get; set; }
    public SpecimenDefinition_TypeTested[]? TypeTested { get; set; }
    public Base.CodeableConcept? TypeCollected { get; set; }
    public Base.CodeableConcept[]? PatientPreparation { get; set; }

    public class SpecimenDefinition_TypeTested_Handling : BackboneElement
    {
        public string? Instruction { get; set; }
        public string? MaxDuration { get; set; }
        public Base.Range? TemperatureRange { get; set; }
        public Base.CodeableConcept? TemperatureQualifier { get; set; }
    }

    public class SpecimenDefinition_TypeTested_Container_Additive : BackboneElement
    {
        public object? Additive    
        {
            get
            {
                if (AdditiveReference is not null)
                {
                    return AdditiveReference;
                }
        
                if (AdditiveCodeableConcept is not null)
                {
                    return AdditiveCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    AdditiveReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    AdditiveCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? AdditiveReference { get; set; }
        public Base.CodeableConcept? AdditiveCodeableConcept { get; set; }
    }

    public class SpecimenDefinition_TypeTested_Container : BackboneElement
    {
        public string? Description { get; set; }
        public Base.Quantity? Capacity { get; set; }
        public Base.Quantity? MinimumVolumeQuantity { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.CodeableConcept? Cap { get; set; }
        public string? Preparation { get; set; }
        public object? MinimumVolume    
        {
            get
            {
                if (MinimumVolumeQuantity is not null)
                {
                    return MinimumVolumeQuantity;
                }
        
                if (MinimumVolumeString is not null)
                {
                    return MinimumVolumeString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    MinimumVolumeQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    MinimumVolumeString = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? Material { get; set; }
        public SpecimenDefinition_TypeTested_Container_Additive[]? Additive { get; set; }
        public string? MinimumVolumeString { get; set; }
    }

    public class SpecimenDefinition_TypeTested : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public SpecimenDefinition_TypeTested_Handling[]? Handling { get; set; }
        public SpecimenDefinition_TypeTested_Container? Container { get; set; }
        public bool? IsDerived { get; set; }
        public required string Preference { get; set; }
        public string? Requirement { get; set; }
        public string? RetentionTime { get; set; }
        public Base.CodeableConcept[]? RejectionCriterion { get; set; }
    }
}