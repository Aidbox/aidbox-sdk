using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ServiceRequest : DomainResource, IResource
{
    public Base.CodeableConcept? PerformerType { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.ResourceReference[]? Insurance { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public Base.ResourceReference[]? RelevantHistory { get; set; }
    public object? AsNeeded    
    {
        get
        {
            if (AsNeededBoolean is not null)
            {
                return AsNeededBoolean;
            }
    
            if (AsNeededCodeableConcept is not null)
            {
                return AsNeededCodeableConcept;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(bool))
            {
                AsNeededBoolean = (bool)value;return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                AsNeededCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference[]? SupportingInfo { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public string? PatientInstruction { get; set; }
    public Base.ResourceReference[]? Specimen { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public string? AuthoredOn { get; set; }
    public string? OccurrenceTiming { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public bool? AsNeededBoolean { get; set; }
    public Base.Identifier? Requisition { get; set; }
    public Base.ResourceReference[]? LocationReference { get; set; }
    public Base.ResourceReference? Requester { get; set; }
    public string? Priority { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public required string Status { get; set; }
    public Base.Ratio? QuantityRatio { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public bool? DoNotPerform { get; set; }
    public Base.CodeableConcept[]? BodySite { get; set; }
    public required string Intent { get; set; }
    public Base.Range? QuantityRange { get; set; }
    public Base.Quantity? QuantityQuantity { get; set; }
    public Base.ResourceReference[]? Replaces { get; set; }
    public Base.CodeableConcept[]? OrderDetail { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public object? Quantity    
    {
        get
        {
            if (QuantityRatio is not null)
            {
                return QuantityRatio;
            }
    
            if (QuantityRange is not null)
            {
                return QuantityRange;
            }
    
            if (QuantityQuantity is not null)
            {
                return QuantityQuantity;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Ratio))
            {
                QuantityRatio = (Base.Ratio)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Range))
            {
                QuantityRange = (Base.Range)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Quantity))
            {
                QuantityQuantity = (Base.Quantity)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept[]? LocationCode { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public Base.CodeableConcept? AsNeededCodeableConcept { get; set; }
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
    public Base.ResourceReference[]? Performer { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }
}