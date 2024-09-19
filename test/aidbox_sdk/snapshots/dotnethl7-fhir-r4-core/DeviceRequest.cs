using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class DeviceRequest : DomainResource, IResource
{
    public Base.CodeableConcept? PerformerType { get; set; }
    public Base.ResourceReference[]? Insurance { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public Base.ResourceReference[]? RelevantHistory { get; set; }
    public Base.ResourceReference[]? SupportingInfo { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.ResourceReference[]? PriorRequest { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public string? AuthoredOn { get; set; }
    public string? OccurrenceTiming { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? CodeReference { get; set; }
    public Base.ResourceReference? Requester { get; set; }
    public string? Priority { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public string? Status { get; set; }
    public Base.CodeableConcept? CodeCodeableConcept { get; set; }
    public Base.Identifier? GroupIdentifier { get; set; }
    public object? Code    
    {
        get
        {
            if (CodeReference is not null)
            {
                return CodeReference;
            }
    
            if (CodeCodeableConcept is not null)
            {
                return CodeCodeableConcept;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                CodeReference = (Base.ResourceReference)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                CodeCodeableConcept = (Base.CodeableConcept)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Identifier[]? Identifier { get; set; }
    public required string Intent { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public DeviceRequest_Parameter[]? Parameter { get; set; }
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
                OccurrenceTiming = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                OccurrencePeriod = (Base.Period)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OccurrenceDateTime = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference? Performer { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class DeviceRequest_Parameter : BackboneElement
    {
        public Base.CodeableConcept? Code { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueRange is not null)
                {
                    return ValueRange;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueCodeableConcept is not null)
                {
                    return ValueCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    ValueRange = (Base.Range)value;
                    return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ValueCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Range? ValueRange { get; set; }
        public bool? ValueBoolean { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public Base.CodeableConcept? ValueCodeableConcept { get; set; }
    }
}