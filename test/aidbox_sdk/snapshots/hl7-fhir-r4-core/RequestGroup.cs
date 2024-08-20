using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class RequestGroup : DomainResource, IResource
{
    public string[]? InstantiatesCanonical { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public string? AuthoredOn { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? Author { get; set; }
    public string? Priority { get; set; }
    public required string Status { get; set; }
    public Base.Identifier? GroupIdentifier { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required string Intent { get; set; }
    public RequestGroup_Action[]? Action { get; set; }
    public Base.ResourceReference[]? Replaces { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class RequestGroup_Action_RelatedAction : BackboneElement
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
                    OffsetRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    OffsetDuration = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public required string ActionId { get; set; }
        public Base.Range? OffsetRange { get; set; }
        public required string Relationship { get; set; }
        public string? OffsetDuration { get; set; }
    }

    public class RequestGroup_Action_Condition : BackboneElement
    {
        public required string Kind { get; set; }
        public Base.ResourceExpression? Expression { get; set; }
    }

    public class RequestGroup_Action_Action_RelatedAction : BackboneElement
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
                    OffsetRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    OffsetDuration = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public required string ActionId { get; set; }
        public Base.Range? OffsetRange { get; set; }
        public required string Relationship { get; set; }
        public string? OffsetDuration { get; set; }
    }

    public class RequestGroup_Action_Action_Condition : BackboneElement
    {
        public required string Kind { get; set; }
        public Base.ResourceExpression? Expression { get; set; }
    }

    public class RequestGroup_Action_Action : BackboneElement
    {
        public Base.Range? TimingRange { get; set; }
        public string? Description { get; set; }
        public string? TextEquivalent { get; set; }
        public Base.Period? TimingPeriod { get; set; }
        public RequestGroup_Action_Action_RelatedAction[]? RelatedAction { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference[]? Participant { get; set; }
        public string? Title { get; set; }
        public Base.RelatedArtifact[]? Documentation { get; set; }
        public string? Prefix { get; set; }
        public string? SelectionBehavior { get; set; }
        public string? TimingDateTime { get; set; }
        public string? TimingTiming { get; set; }
        public string? TimingDuration { get; set; }
        public string? Priority { get; set; }
        public string? RequiredBehavior { get; set; }
        public RequestGroup_Action_Action_Condition[]? Condition { get; set; }
        public Base.ResourceReference? Resource { get; set; }
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
        public string? GroupingBehavior { get; set; }
        public Base.CodeableConcept[]? Code { get; set; }
        public string? TimingAge { get; set; }
        public string[]? Action { get; set; }
        public string? PrecheckBehavior { get; set; }
        public string? CardinalityBehavior { get; set; }
    }

    public class RequestGroup_Action : BackboneElement
    {
        public Base.Range? TimingRange { get; set; }
        public string? Description { get; set; }
        public string? TextEquivalent { get; set; }
        public Base.Period? TimingPeriod { get; set; }
        public RequestGroup_Action_RelatedAction[]? RelatedAction { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference[]? Participant { get; set; }
        public string? Title { get; set; }
        public Base.RelatedArtifact[]? Documentation { get; set; }
        public string? Prefix { get; set; }
        public string? SelectionBehavior { get; set; }
        public string? TimingDateTime { get; set; }
        public string? TimingTiming { get; set; }
        public string? TimingDuration { get; set; }
        public string? Priority { get; set; }
        public string? RequiredBehavior { get; set; }
        public RequestGroup_Action_Condition[]? Condition { get; set; }
        public Base.ResourceReference? Resource { get; set; }
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
        public string? GroupingBehavior { get; set; }
        public Base.CodeableConcept[]? Code { get; set; }
        public string? TimingAge { get; set; }
        public RequestGroup_Action_Action[]? Action { get; set; }
        public string? PrecheckBehavior { get; set; }
        public string? CardinalityBehavior { get; set; }
    }
}