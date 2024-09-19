using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class ResearchElementDefinition : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public Base.ContactDetail[]? Endorser { get; set; }
    public string? Publisher { get; set; }
    public string? ApprovalDate { get; set; }
    public string? VariableType { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public Base.CodeableConcept? SubjectCodeableConcept { get; set; }
    public string? Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public required string Type { get; set; }
    public bool? Experimental { get; set; }
    public Base.CodeableConcept[]? Topic { get; set; }
    public string? Title { get; set; }
    public string[]? Library { get; set; }
    public Base.ContactDetail[]? Author { get; set; }
    public required ResearchElementDefinition_Characteristic[] Characteristic { get; set; }
    public string? Usage { get; set; }
    public required string Status { get; set; }
    public string? Subtitle { get; set; }
    public string[]? Comment { get; set; }
    public string? Url { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? LastReviewDate { get; set; }
    public Base.ContactDetail[]? Editor { get; set; }
    public Base.ContactDetail[]? Reviewer { get; set; }
    public string? ShortTitle { get; set; }
    public string? Version { get; set; }
    public Base.RelatedArtifact[]? RelatedArtifact { get; set; }
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
                SubjectCodeableConcept = (Base.CodeableConcept)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                SubjectReference = (Base.ResourceReference)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Period? EffectivePeriod { get; set; }

    public class ResearchElementDefinition_Characteristic : BackboneElement
    {
        public object? Definition    
        {
            get
            {
                if (DefinitionExpression is not null)
                {
                    return DefinitionExpression;
                }
        
                if (DefinitionDataRequirement is not null)
                {
                    return DefinitionDataRequirement;
                }
        
                if (DefinitionCanonical is not null)
                {
                    return DefinitionCanonical;
                }
        
                if (DefinitionCodeableConcept is not null)
                {
                    return DefinitionCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceExpression))
                {
                    DefinitionExpression = (Base.ResourceExpression)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.DataRequirement))
                {
                    DefinitionDataRequirement = (Base.DataRequirement)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefinitionCanonical = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DefinitionCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? StudyEffectiveTiming { get; set; }
        public bool? Exclude { get; set; }
        public Base.ResourceExpression? DefinitionExpression { get; set; }
        public string? ParticipantEffectiveDuration { get; set; }
        public string? StudyEffectiveDuration { get; set; }
        public Base.DataRequirement? DefinitionDataRequirement { get; set; }
        public string? DefinitionCanonical { get; set; }
        public string? StudyEffectiveGroupMeasure { get; set; }
        public string? ParticipantEffectiveTiming { get; set; }
        public string? ParticipantEffectiveGroupMeasure { get; set; }
        public string? StudyEffectiveDescription { get; set; }
        public string? ParticipantEffectiveDateTime { get; set; }
        public string? StudyEffectiveTimeFromStart { get; set; }
        public Base.CodeableConcept? UnitOfMeasure { get; set; }
        public Base.Period? ParticipantEffectivePeriod { get; set; }
        public object? StudyEffective    
        {
            get
            {
                if (StudyEffectiveTiming is not null)
                {
                    return StudyEffectiveTiming;
                }
        
                if (StudyEffectiveDuration is not null)
                {
                    return StudyEffectiveDuration;
                }
        
                if (StudyEffectivePeriod is not null)
                {
                    return StudyEffectivePeriod;
                }
        
                if (StudyEffectiveDateTime is not null)
                {
                    return StudyEffectiveDateTime;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    StudyEffectiveTiming = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    StudyEffectiveDuration = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    StudyEffectivePeriod = (Base.Period)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    StudyEffectiveDateTime = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ParticipantEffectiveDescription { get; set; }
        public Base.CodeableConcept? DefinitionCodeableConcept { get; set; }
        public object? ParticipantEffective    
        {
            get
            {
                if (ParticipantEffectiveDuration is not null)
                {
                    return ParticipantEffectiveDuration;
                }
        
                if (ParticipantEffectiveTiming is not null)
                {
                    return ParticipantEffectiveTiming;
                }
        
                if (ParticipantEffectiveDateTime is not null)
                {
                    return ParticipantEffectiveDateTime;
                }
        
                if (ParticipantEffectivePeriod is not null)
                {
                    return ParticipantEffectivePeriod;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ParticipantEffectiveDuration = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ParticipantEffectiveTiming = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ParticipantEffectiveDateTime = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    ParticipantEffectivePeriod = (Base.Period)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.UsageContext[]? UsageContext { get; set; }
        public Base.Period? StudyEffectivePeriod { get; set; }
        public string? ParticipantEffectiveTimeFromStart { get; set; }
        public string? StudyEffectiveDateTime { get; set; }
    }
}