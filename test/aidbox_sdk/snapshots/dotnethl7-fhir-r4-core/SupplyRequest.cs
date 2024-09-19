using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class SupplyRequest : DomainResource, IResource
{
    public Base.CodeableConcept? Category { get; set; }
    public Base.ResourceReference[]? Supplier { get; set; }
    public Base.ResourceReference? DeliverTo { get; set; }
    public Base.ResourceReference? ItemReference { get; set; }
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
                ItemReference = (Base.ResourceReference)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                ItemCodeableConcept = (Base.CodeableConcept)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public string? AuthoredOn { get; set; }
    public string? OccurrenceTiming { get; set; }
    public Base.ResourceReference? DeliverFrom { get; set; }
    public Base.ResourceReference? Requester { get; set; }
    public string? Priority { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public string? Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.CodeableConcept? ItemCodeableConcept { get; set; }
    public required Base.Quantity Quantity { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public SupplyRequest_Parameter[]? Parameter { get; set; }
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
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class SupplyRequest_Parameter : BackboneElement
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