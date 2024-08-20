using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class EvidenceVariable : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public Base.ContactDetail[]? Endorser { get; set; }
    public string? Publisher { get; set; }
    public string? ApprovalDate { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public string? Type { get; set; }
    public Base.CodeableConcept[]? Topic { get; set; }
    public string? Title { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ContactDetail[]? Author { get; set; }
    public required EvidenceVariable_Characteristic[] Characteristic { get; set; }
    public required string Status { get; set; }
    public string? Subtitle { get; set; }
    public string? Url { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? LastReviewDate { get; set; }
    public Base.ContactDetail[]? Editor { get; set; }
    public Base.ContactDetail[]? Reviewer { get; set; }
    public string? ShortTitle { get; set; }
    public string? Version { get; set; }
    public Base.RelatedArtifact[]? RelatedArtifact { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }
    public Base.Period? EffectivePeriod { get; set; }

    public class EvidenceVariable_Characteristic : BackboneElement
    {
        public string? Description { get; set; }
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
        
                if (DefinitionTriggerDefinition is not null)
                {
                    return DefinitionTriggerDefinition;
                }
        
                if (DefinitionCanonical is not null)
                {
                    return DefinitionCanonical;
                }
        
                if (DefinitionReference is not null)
                {
                    return DefinitionReference;
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
                    DefinitionExpression = (Base.ResourceExpression)value;return;
                }
        
                if (value?.GetType() == typeof(Base.DataRequirement))
                {
                    DefinitionDataRequirement = (Base.DataRequirement)value;return;
                }
        
                if (value?.GetType() == typeof(Base.TriggerDefinition))
                {
                    DefinitionTriggerDefinition = (Base.TriggerDefinition)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefinitionCanonical = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    DefinitionReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DefinitionCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public bool? Exclude { get; set; }
        public string? GroupMeasure { get; set; }
        public Base.ResourceExpression? DefinitionExpression { get; set; }
        public string? TimeFromStart { get; set; }
        public string? ParticipantEffectiveDuration { get; set; }
        public Base.DataRequirement? DefinitionDataRequirement { get; set; }
        public Base.TriggerDefinition? DefinitionTriggerDefinition { get; set; }
        public string? DefinitionCanonical { get; set; }
        public Base.ResourceReference? DefinitionReference { get; set; }
        public string? ParticipantEffectiveTiming { get; set; }
        public string? ParticipantEffectiveDateTime { get; set; }
        public Base.Period? ParticipantEffectivePeriod { get; set; }
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
                    ParticipantEffectiveDuration = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ParticipantEffectiveTiming = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ParticipantEffectiveDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    ParticipantEffectivePeriod = (Base.Period)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.UsageContext[]? UsageContext { get; set; }
    }
}