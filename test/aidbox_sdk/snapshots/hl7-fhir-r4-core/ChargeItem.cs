using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ChargeItem : DomainResource, IResource
{
    public Base.ResourceReference[]? Service { get; set; }
    public string[]? DefinitionUri { get; set; }
    public Base.ResourceReference? Enterer { get; set; }
    public Base.ResourceReference? RequestingOrganization { get; set; }
    public Base.CodeableConcept? ProductCodeableConcept { get; set; }
    public Base.ResourceReference? ProductReference { get; set; }
    public string[]? DefinitionCanonical { get; set; }
    public Base.CodeableConcept[]? Bodysite { get; set; }
    public string? OccurrenceTiming { get; set; }
    public Base.ResourceReference? CostCenter { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference[]? Account { get; set; }
    public Base.CodeableConcept[]? Reason { get; set; }
    public object? Product    
    {
        get
        {
            if (ProductCodeableConcept is not null)
            {
                return ProductCodeableConcept;
            }
    
            if (ProductReference is not null)
            {
                return ProductReference;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                ProductCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                ProductReference = (Base.ResourceReference)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference[]? SupportingInformation { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public required string Status { get; set; }
    public required Base.CodeableConcept Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? Context { get; set; }
    public Base.Quantity? Quantity { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public Base.Money? PriceOverride { get; set; }
    public string? EnteredDate { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public string? OverrideReason { get; set; }
    public Base.ResourceReference? PerformingOrganization { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public string? FactorOverride { get; set; }
    public object? Occurrence    
    {
        get
        {
            if (OccurrenceTiming is not null)
            {
                return OccurrenceTiming;
            }
    
            if (OccurrencePeriod is not null)
            {
                return OccurrencePeriod;
            }
    
            if (OccurrenceDateTime is not null)
            {
                return OccurrenceDateTime;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                OccurrenceTiming = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                OccurrencePeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OccurrenceDateTime = (string)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public ChargeItem_Performer[]? Performer { get; set; }

    public class ChargeItem_Performer : BackboneElement
    {
        public required Base.ResourceReference Actor { get; set; }
        public Base.CodeableConcept? Function { get; set; }
    }
}