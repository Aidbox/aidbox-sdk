using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class Observation : DomainResource, IResource
{
    public Base.CodeableConcept[]? Category { get; set; }
    public Observation_ReferenceRange[]? ReferenceRange { get; set; }
    public Base.ResourceReference[]? HasMember { get; set; }
    public Base.ResourceReference[]? DerivedFrom { get; set; }
    public Base.CodeableConcept[]? Interpretation { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.CodeableConcept? Method { get; set; }
    public string? ValueTime { get; set; }
    public Base.ResourceReference? Specimen { get; set; }
    public Base.Quantity? ValueQuantity { get; set; }
    public object? Value    
    {
        get
        {
            if (ValueTime is not null)
            {
                return ValueTime;
            }
    
            if (ValueQuantity is not null)
            {
                return ValueQuantity;
            }
    
            if (ValueString is not null)
            {
                return ValueString;
            }
    
            if (ValueRatio is not null)
            {
                return ValueRatio;
            }
    
            if (ValueBoolean is not null)
            {
                return ValueBoolean;
            }
    
            if (ValueDateTime is not null)
            {
                return ValueDateTime;
            }
    
            if (ValueSampledData is not null)
            {
                return ValueSampledData;
            }
    
            if (ValueCodeableConcept is not null)
            {
                return ValueCodeableConcept;
            }
    
            if (ValuePeriod is not null)
            {
                return ValuePeriod;
            }
    
            if (ValueRange is not null)
            {
                return ValueRange;
            }
    
            if (ValueInteger is not null)
            {
                return ValueInteger;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                ValueTime = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Quantity))
            {
                ValueQuantity = (Base.Quantity)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                ValueString = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Ratio))
            {
                ValueRatio = (Base.Ratio)value;return;
            }
    
            if (value?.GetType() == typeof(bool))
            {
                ValueBoolean = (bool)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                ValueDateTime = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.SampledData))
            {
                ValueSampledData = (Base.SampledData)value;return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                ValueCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                ValuePeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Range))
            {
                ValueRange = (Base.Range)value;return;
            }
    
            if (value?.GetType() == typeof(int))
            {
                ValueInteger = (int)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public string? ValueString { get; set; }
    public Base.Ratio? ValueRatio { get; set; }
    public bool? ValueBoolean { get; set; }
    public string? ValueDateTime { get; set; }
    public Observation_Component[]? Component { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.SampledData? ValueSampledData { get; set; }
    public string? EffectiveDateTime { get; set; }
    public required string Status { get; set; }
    public object? Effective    
    {
        get
        {
            if (EffectiveDateTime is not null)
            {
                return EffectiveDateTime;
            }
    
            if (EffectiveTiming is not null)
            {
                return EffectiveTiming;
            }
    
            if (EffectiveInstant is not null)
            {
                return EffectiveInstant;
            }
    
            if (EffectivePeriod is not null)
            {
                return EffectivePeriod;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                EffectiveDateTime = (string)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                EffectiveTiming = (string)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                EffectiveInstant = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                EffectivePeriod = (Base.Period)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public required Base.CodeableConcept Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? EffectiveTiming { get; set; }
    public Base.CodeableConcept? ValueCodeableConcept { get; set; }
    public Base.CodeableConcept? BodySite { get; set; }
    public Base.ResourceReference[]? Focus { get; set; }
    public string? Issued { get; set; }
    public Base.Period? ValuePeriod { get; set; }
    public Base.ResourceReference? Device { get; set; }
    public string? EffectiveInstant { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.Range? ValueRange { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public int? ValueInteger { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference[]? Performer { get; set; }
    public Base.CodeableConcept? DataAbsentReason { get; set; }
    public Base.Period? EffectivePeriod { get; set; }

    public class Observation_ReferenceRange : BackboneElement
    {
        public Base.Range? Age { get; set; }
        public Base.Quantity? Low { get; set; }
        public Base.Quantity? High { get; set; }
        public string? Text { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.CodeableConcept[]? AppliesTo { get; set; }
    }

    public class Observation_Component_ReferenceRange : BackboneElement
    {
        public Base.Range? Age { get; set; }
        public Base.Quantity? Low { get; set; }
        public Base.Quantity? High { get; set; }
        public string? Text { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.CodeableConcept[]? AppliesTo { get; set; }
    }

    public class Observation_Component : BackboneElement
    {
        public Observation_Component_ReferenceRange[]? ReferenceRange { get; set; }
        public Base.CodeableConcept[]? Interpretation { get; set; }
        public string? ValueTime { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueRatio is not null)
                {
                    return ValueRatio;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueSampledData is not null)
                {
                    return ValueSampledData;
                }
        
                if (ValueCodeableConcept is not null)
                {
                    return ValueCodeableConcept;
                }
        
                if (ValuePeriod is not null)
                {
                    return ValuePeriod;
                }
        
                if (ValueRange is not null)
                {
                    return ValueRange;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    ValueRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.SampledData))
                {
                    ValueSampledData = (Base.SampledData)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ValueCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    ValuePeriod = (Base.Period)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    ValueRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueString { get; set; }
        public Base.Ratio? ValueRatio { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueDateTime { get; set; }
        public Base.SampledData? ValueSampledData { get; set; }
        public required Base.CodeableConcept Code { get; set; }
        public Base.CodeableConcept? ValueCodeableConcept { get; set; }
        public Base.Period? ValuePeriod { get; set; }
        public Base.Range? ValueRange { get; set; }
        public int? ValueInteger { get; set; }
        public Base.CodeableConcept? DataAbsentReason { get; set; }
    }
}