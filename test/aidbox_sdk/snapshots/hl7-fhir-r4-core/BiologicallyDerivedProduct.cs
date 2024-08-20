using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class BiologicallyDerivedProduct : DomainResource, IResource
{
    public Base.ResourceReference[]? Request { get; set; }
    public BiologicallyDerivedProduct_Processing[]? Processing { get; set; }
    public Base.ResourceReference[]? Parent { get; set; }
    public string? Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.CodeableConcept? ProductCode { get; set; }
    public BiologicallyDerivedProduct_Storage[]? Storage { get; set; }
    public int? Quantity { get; set; }
    public string? ProductCategory { get; set; }
    public BiologicallyDerivedProduct_Manipulation? Manipulation { get; set; }
    public BiologicallyDerivedProduct_Collection? Collection { get; set; }

    public class BiologicallyDerivedProduct_Processing : BackboneElement
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
                    TimePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimeDateTime = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? Additive { get; set; }
        public Base.CodeableConcept? Procedure { get; set; }
        public Base.Period? TimePeriod { get; set; }
        public string? Description { get; set; }
        public string? TimeDateTime { get; set; }
    }

    public class BiologicallyDerivedProduct_Storage : BackboneElement
    {
        public string? Scale { get; set; }
        public Base.Period? Duration { get; set; }
        public string? Description { get; set; }
        public string? Temperature { get; set; }
    }

    public class BiologicallyDerivedProduct_Manipulation : BackboneElement
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
                    TimePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimeDateTime = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Period? TimePeriod { get; set; }
        public string? Description { get; set; }
        public string? TimeDateTime { get; set; }
    }

    public class BiologicallyDerivedProduct_Collection : BackboneElement
    {
        public Base.ResourceReference? Source { get; set; }
        public object? Collected    
        {
            get
            {
                if (CollectedPeriod is not null)
                {
                    return CollectedPeriod;
                }
        
                if (CollectedDateTime is not null)
                {
                    return CollectedDateTime;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Period))
                {
                    CollectedPeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    CollectedDateTime = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? Collector { get; set; }
        public Base.Period? CollectedPeriod { get; set; }
        public string? CollectedDateTime { get; set; }
    }
}