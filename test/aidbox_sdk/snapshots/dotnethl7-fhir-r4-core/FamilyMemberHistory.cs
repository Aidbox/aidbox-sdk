using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class FamilyMemberHistory : DomainResource, IResource
{
    public string? DeceasedAge { get; set; }
    public required Base.ResourceReference Patient { get; set; }
    public string? Date { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public object? Age    
    {
        get
        {
            if (AgeRange is not null)
            {
                return AgeRange;
            }
    
            if (AgeString is not null)
            {
                return AgeString;
            }
    
            if (AgeAge is not null)
            {
                return AgeAge;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Range))
            {
                AgeRange = (Base.Range)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                AgeString = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                AgeAge = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept? Sex { get; set; }
    public Base.Range? AgeRange { get; set; }
    public string? BornString { get; set; }
    public bool? DeceasedBoolean { get; set; }
    public string? Name { get; set; }
    public required Base.CodeableConcept Relationship { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public object? Deceased    
    {
        get
        {
            if (DeceasedAge is not null)
            {
                return DeceasedAge;
            }
    
            if (DeceasedBoolean is not null)
            {
                return DeceasedBoolean;
            }
    
            if (DeceasedRange is not null)
            {
                return DeceasedRange;
            }
    
            if (DeceasedDate is not null)
            {
                return DeceasedDate;
            }
    
            if (DeceasedString is not null)
            {
                return DeceasedString;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                DeceasedAge = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(bool))
            {
                DeceasedBoolean = (bool)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.Range))
            {
                DeceasedRange = (Base.Range)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                DeceasedDate = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                DeceasedString = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Annotation[]? Note { get; set; }
    public required string Status { get; set; }
    public FamilyMemberHistory_Condition[]? Condition { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public object? Born    
    {
        get
        {
            if (BornString is not null)
            {
                return BornString;
            }
    
            if (BornPeriod is not null)
            {
                return BornPeriod;
            }
    
            if (BornDate is not null)
            {
                return BornDate;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                BornString = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                BornPeriod = (Base.Period)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                BornDate = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public string? AgeString { get; set; }
    public Base.Range? DeceasedRange { get; set; }
    public string? DeceasedDate { get; set; }
    public Base.Period? BornPeriod { get; set; }
    public string? DeceasedString { get; set; }
    public string? AgeAge { get; set; }
    public string? BornDate { get; set; }
    public Base.CodeableConcept? DataAbsentReason { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }
    public bool? EstimatedAge { get; set; }

    public class FamilyMemberHistory_Condition : BackboneElement
    {
        public object? Onset    
        {
            get
            {
                if (OnsetRange is not null)
                {
                    return OnsetRange;
                }
        
                if (OnsetAge is not null)
                {
                    return OnsetAge;
                }
        
                if (OnsetPeriod is not null)
                {
                    return OnsetPeriod;
                }
        
                if (OnsetString is not null)
                {
                    return OnsetString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    OnsetRange = (Base.Range)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    OnsetAge = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    OnsetPeriod = (Base.Period)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    OnsetString = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Range? OnsetRange { get; set; }
        public string? OnsetAge { get; set; }
        public bool? ContributedToDeath { get; set; }
        public Base.Period? OnsetPeriod { get; set; }
        public Base.CodeableConcept? Outcome { get; set; }
        public Base.Annotation[]? Note { get; set; }
        public string? OnsetString { get; set; }
        public required Base.CodeableConcept Code { get; set; }
    }
}