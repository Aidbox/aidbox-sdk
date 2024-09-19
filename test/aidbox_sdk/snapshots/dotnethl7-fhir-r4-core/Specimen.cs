using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Specimen : DomainResource, IResource
{
    public Base.ResourceReference[]? Request { get; set; }
    public string? ReceivedTime { get; set; }
    public Specimen_Processing[]? Processing { get; set; }
    public Base.ResourceReference[]? Parent { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public string? Status { get; set; }
    public Base.CodeableConcept[]? Condition { get; set; }
    public Specimen_Container[]? Container { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.Identifier? AccessionIdentifier { get; set; }
    public Specimen_Collection? Collection { get; set; }
    public Base.ResourceReference? Subject { get; set; }

    public class Specimen_Processing : BackboneElement
    {
        public object? Time    
        {
            get
            {
                if (TimePeriod is not null)
                {
                    return TimePeriod;
                }
        
                if (TimeDateTime is not null)
                {
                    return TimeDateTime;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Period))
                {
                    TimePeriod = (Base.Period)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimeDateTime = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference[]? Additive { get; set; }
        public Base.CodeableConcept? Procedure { get; set; }
        public Base.Period? TimePeriod { get; set; }
        public string? Description { get; set; }
        public string? TimeDateTime { get; set; }
    }

    public class Specimen_Container : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
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
                    AdditiveReference = (Base.ResourceReference)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    AdditiveCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Quantity? Capacity { get; set; }
        public Base.Identifier[]? Identifier { get; set; }
        public string? Description { get; set; }
        public Base.Quantity? SpecimenQuantity { get; set; }
        public Base.ResourceReference? AdditiveReference { get; set; }
        public Base.CodeableConcept? AdditiveCodeableConcept { get; set; }
    }

    public class Specimen_Collection : BackboneElement
    {
        public string? CollectedDateTime { get; set; }
        public Base.CodeableConcept? FastingStatusCodeableConcept { get; set; }
        public object? FastingStatus    
        {
            get
            {
                if (FastingStatusCodeableConcept is not null)
                {
                    return FastingStatusCodeableConcept;
                }
        
                if (FastingStatusDuration is not null)
                {
                    return FastingStatusDuration;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    FastingStatusCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    FastingStatusDuration = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? Method { get; set; }
        public string? FastingStatusDuration { get; set; }
        public string? Duration { get; set; }
        public Base.ResourceReference? Collector { get; set; }
        public Base.CodeableConcept? BodySite { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.Period? CollectedPeriod { get; set; }
        public object? Collected    
        {
            get
            {
                if (CollectedDateTime is not null)
                {
                    return CollectedDateTime;
                }
        
                if (CollectedPeriod is not null)
                {
                    return CollectedPeriod;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    CollectedDateTime = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    CollectedPeriod = (Base.Period)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
    }
}