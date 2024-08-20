using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Condition : DomainResource, IResource
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
    
            if (OnsetDateTime is not null)
            {
                return OnsetDateTime;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Range))
            {
                OnsetRange = (Base.Range)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OnsetAge = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                OnsetPeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OnsetString = (string)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OnsetDateTime = (string)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.CodeableConcept? ClinicalStatus { get; set; }
    public string? AbatementAge { get; set; }
    public Base.Range? OnsetRange { get; set; }
    public string? OnsetAge { get; set; }
    public Condition_Stage[]? Stage { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Condition_Evidence[]? Evidence { get; set; }
    public Base.Period? OnsetPeriod { get; set; }
    public object? Abatement    
    {
        get
        {
            if (AbatementAge is not null)
            {
                return AbatementAge;
            }
    
            if (AbatementPeriod is not null)
            {
                return AbatementPeriod;
            }
    
            if (AbatementString is not null)
            {
                return AbatementString;
            }
    
            if (AbatementRange is not null)
            {
                return AbatementRange;
            }
    
            if (AbatementDateTime is not null)
            {
                return AbatementDateTime;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                AbatementAge = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                AbatementPeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                AbatementString = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Range))
            {
                AbatementRange = (Base.Range)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                AbatementDateTime = (string)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Period? AbatementPeriod { get; set; }
    public Base.ResourceReference? Asserter { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public string? AbatementString { get; set; }
    public Base.Range? AbatementRange { get; set; }
    public string? RecordedDate { get; set; }
    public string? OnsetString { get; set; }
    public Base.ResourceReference? Recorder { get; set; }
    public Base.CodeableConcept? Severity { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? OnsetDateTime { get; set; }
    public Base.CodeableConcept[]? BodySite { get; set; }
    public string? AbatementDateTime { get; set; }
    public Base.CodeableConcept? VerificationStatus { get; set; }
    public required Base.ResourceReference Subject { get; set; }

    public class Condition_Stage : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.CodeableConcept? Summary { get; set; }
        public Base.ResourceReference[]? Assessment { get; set; }
    }

    public class Condition_Evidence : BackboneElement
    {
        public Base.CodeableConcept[]? Code { get; set; }
        public Base.ResourceReference[]? Detail { get; set; }
    }
}