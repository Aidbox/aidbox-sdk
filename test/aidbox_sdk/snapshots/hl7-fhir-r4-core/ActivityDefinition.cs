using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ActivityDefinition : DomainResource, IResource
{
    public Base.ResourceReference[]? ObservationResultRequirement { get; set; }
    public Base.Range? TimingRange { get; set; }
    public string? Description { get; set; }
    public string? Date { get; set; }
    public string? Transform { get; set; }
    public Base.ContactDetail[]? Endorser { get; set; }
    public string? Publisher { get; set; }
    public string? ApprovalDate { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string[]? Dosage { get; set; }
    public Base.ResourceReference[]? ObservationRequirement { get; set; }
    public string? Purpose { get; set; }
    public Base.CodeableConcept? SubjectCodeableConcept { get; set; }
    public Base.CodeableConcept? ProductCodeableConcept { get; set; }
    public string? Name { get; set; }
    public Base.ResourceReference? ProductReference { get; set; }
    public Base.Period? TimingPeriod { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public Base.CodeableConcept[]? Topic { get; set; }
    public ActivityDefinition_Participant[]? Participant { get; set; }
    public string? Title { get; set; }
    public string[]? Library { get; set; }
    public Base.ContactDetail[]? Author { get; set; }
    public string? TimingDateTime { get; set; }
    public string? TimingTiming { get; set; }
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
    public string? Usage { get; set; }
    public string? TimingDuration { get; set; }
    public string? Priority { get; set; }
    public required string Status { get; set; }
    public object? Timing    
    {
        get
        {
            if (TimingRange is not null)
            {
                return TimingRange;
            }
    
            if (TimingPeriod is not null)
            {
                return TimingPeriod;
            }
    
            if (TimingDateTime is not null)
            {
                return TimingDateTime;
            }
    
            if (TimingTiming is not null)
            {
                return TimingTiming;
            }
    
            if (TimingDuration is not null)
            {
                return TimingDuration;
            }
    
            if (TimingAge is not null)
            {
                return TimingAge;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Range))
            {
                TimingRange = (Base.Range)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                TimingPeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                TimingDateTime = (string)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                TimingTiming = (string)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                TimingDuration = (string)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                TimingAge = (string)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public string? Subtitle { get; set; }
    public string? Kind { get; set; }
    public ActivityDefinition_DynamicValue[]? DynamicValue { get; set; }
    public string? Url { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? LastReviewDate { get; set; }
    public Base.ContactDetail[]? Editor { get; set; }
    public bool? DoNotPerform { get; set; }
    public Base.CodeableConcept[]? BodySite { get; set; }
    public string? TimingAge { get; set; }
    public string? Intent { get; set; }
    public Base.ResourceReference[]? SpecimenRequirement { get; set; }
    public Base.ContactDetail[]? Reviewer { get; set; }
    public Base.Quantity? Quantity { get; set; }
    public string? Version { get; set; }
    public Base.RelatedArtifact[]? RelatedArtifact { get; set; }
    public Base.ResourceReference? Location { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }
    public Base.ResourceReference? SubjectReference { get; set; }
    public object? Subject    
    {
        get
        {
            if (SubjectCodeableConcept is not null)
            {
                return SubjectCodeableConcept;
            }
    
            if (SubjectReference is not null)
            {
                return SubjectReference;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                SubjectCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                SubjectReference = (Base.ResourceReference)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public string? Profile { get; set; }
    public Base.Period? EffectivePeriod { get; set; }

    public class ActivityDefinition_Participant : BackboneElement
    {
        public Base.CodeableConcept? Role { get; set; }
        public required string Type { get; set; }
    }

    public class ActivityDefinition_DynamicValue : BackboneElement
    {
        public required string Path { get; set; }
        public required Base.ResourceExpression Expression { get; set; }
    }
}