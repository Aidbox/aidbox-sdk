using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class PlanDefinition : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public Base.ContactDetail[]? Endorser { get; set; }
    public string? Publisher { get; set; }
    public string? ApprovalDate { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public Base.CodeableConcept? SubjectCodeableConcept { get; set; }
    public string? Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public PlanDefinition_Goal[]? Goal { get; set; }
    public string? Copyright { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public bool? Experimental { get; set; }
    public Base.CodeableConcept[]? Topic { get; set; }
    public string? Title { get; set; }
    public string[]? Library { get; set; }
    public Base.ContactDetail[]? Author { get; set; }
    public string? Usage { get; set; }
    public required string Status { get; set; }
    public string? Subtitle { get; set; }
    public string? Url { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? LastReviewDate { get; set; }
    public Base.ContactDetail[]? Editor { get; set; }
    public PlanDefinition_Action[]? Action { get; set; }
    public Base.ContactDetail[]? Reviewer { get; set; }
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

    public class PlanDefinition_Goal_Target : BackboneElement
    {
        public string? Due { get; set; }
        public object? Detail    
        {
            get
            {
                if (DetailRange is not null)
                {
                    return DetailRange;
                }
        
                if (DetailQuantity is not null)
                {
                    return DetailQuantity;
                }
        
                if (DetailCodeableConcept is not null)
                {
                    return DetailCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    DetailRange = (Base.Range)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    DetailQuantity = (Base.Quantity)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DetailCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? Measure { get; set; }
        public Base.Range? DetailRange { get; set; }
        public Base.Quantity? DetailQuantity { get; set; }
        public Base.CodeableConcept? DetailCodeableConcept { get; set; }
    }

    public class PlanDefinition_Goal : BackboneElement
    {
        public Base.CodeableConcept? Start { get; set; }
        public PlanDefinition_Goal_Target[]? Target { get; set; }
        public Base.CodeableConcept? Category { get; set; }
        public Base.CodeableConcept? Priority { get; set; }
        public Base.CodeableConcept[]? Addresses { get; set; }
        public required Base.CodeableConcept Description { get; set; }
        public Base.RelatedArtifact[]? Documentation { get; set; }
    }

    public class PlanDefinition_Action_RelatedAction : BackboneElement
    {
        public object? Offset    
        {
            get
            {
                if (OffsetRange is not null)
                {
                    return OffsetRange;
                }
        
                if (OffsetDuration is not null)
                {
                    return OffsetDuration;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    OffsetRange = (Base.Range)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    OffsetDuration = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public required string ActionId { get; set; }
        public Base.Range? OffsetRange { get; set; }
        public required string Relationship { get; set; }
        public string? OffsetDuration { get; set; }
    }

    public class PlanDefinition_Action_Participant : BackboneElement
    {
        public Base.CodeableConcept? Role { get; set; }
        public required string Type { get; set; }
    }

    public class PlanDefinition_Action_Condition : BackboneElement
    {
        public required string Kind { get; set; }
        public Base.ResourceExpression? Expression { get; set; }
    }

    public class PlanDefinition_Action_DynamicValue : BackboneElement
    {
        public string? Path { get; set; }
        public Base.ResourceExpression? Expression { get; set; }
    }

    public class PlanDefinition_Action : BackboneElement
    {
        public Base.Range? TimingRange { get; set; }
        public string? Description { get; set; }
        public object? Definition    
        {
            get
            {
                if (DefinitionUri is not null)
                {
                    return DefinitionUri;
                }
        
                if (DefinitionCanonical is not null)
                {
                    return DefinitionCanonical;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    DefinitionUri = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DefinitionCanonical = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? Transform { get; set; }
        public string? TextEquivalent { get; set; }
        public string? DefinitionUri { get; set; }
        public string[]? GoalId { get; set; }
        public Base.CodeableConcept? SubjectCodeableConcept { get; set; }
        public Base.Period? TimingPeriod { get; set; }
        public string? DefinitionCanonical { get; set; }
        public PlanDefinition_Action_RelatedAction[]? RelatedAction { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public PlanDefinition_Action_Participant[]? Participant { get; set; }
        public Base.DataRequirement[]? Output { get; set; }
        public string? Title { get; set; }
        public Base.RelatedArtifact[]? Documentation { get; set; }
        public string? Prefix { get; set; }
        public string? SelectionBehavior { get; set; }
        public Base.CodeableConcept[]? Reason { get; set; }
        public string? TimingDateTime { get; set; }
        public string? TimingTiming { get; set; }
        public string? TimingDuration { get; set; }
        public string? Priority { get; set; }
        public string? RequiredBehavior { get; set; }
        public PlanDefinition_Action_Condition[]? Condition { get; set; }
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
                    TimingRange = (Base.Range)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    TimingPeriod = (Base.Period)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimingDateTime = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimingTiming = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimingDuration = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    TimingAge = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? GroupingBehavior { get; set; }
        public PlanDefinition_Action_DynamicValue[]? DynamicValue { get; set; }
        public Base.CodeableConcept[]? Code { get; set; }
        public string? TimingAge { get; set; }
        public Base.ResourceReference[]? Action { get; set; }
        public string? PrecheckBehavior { get; set; }
        public Base.DataRequirement[]? Input { get; set; }
        public Base.TriggerDefinition[]? Trigger { get; set; }
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
        public string? CardinalityBehavior { get; set; }
    }
}