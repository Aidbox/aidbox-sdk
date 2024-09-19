using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class SupplyDelivery : DomainResource, IResource
{
    public Base.ResourceReference? Patient { get; set; }
    public Base.ResourceReference? Supplier { get; set; }
    public SupplyDelivery_SuppliedItem? SuppliedItem { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public string? OccurrenceTiming { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public string? Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public Base.ResourceReference[]? Receiver { get; set; }
    public Base.ResourceReference? Destination { get; set; }
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

    public class SupplyDelivery_SuppliedItem : BackboneElement
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
        public Base.Quantity? Quantity { get; set; }
        public Base.ResourceReference? ItemReference { get; set; }
        public Base.CodeableConcept? ItemCodeableConcept { get; set; }
    }
}