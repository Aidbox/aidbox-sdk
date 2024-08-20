using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class CommunicationRequest : DomainResource, IResource
{
    public Base.CodeableConcept[]? Category { get; set; }
    public CommunicationRequest_Payload[]? Payload { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.CodeableConcept[]? Medium { get; set; }
    public Base.ResourceReference[]? Recipient { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.CodeableConcept? StatusReason { get; set; }
    public string? AuthoredOn { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? Requester { get; set; }
    public string? Priority { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public required string Status { get; set; }
    public Base.Identifier? GroupIdentifier { get; set; }
    public Base.ResourceReference? Sender { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public bool? DoNotPerform { get; set; }
    public Base.ResourceReference[]? Replaces { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public object? Occurrence    
    {
        get
        {
            if (OccurrencePeriod is not null)
            {
                return OccurrencePeriod;
            }
    
            if (OccurrenceDateTime is not null)
            {
                return OccurrenceDateTime;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Period))
            {
                OccurrencePeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OccurrenceDateTime = (string)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference[]? About { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class CommunicationRequest_Payload : BackboneElement
    {
        public object? Content    
        {
            get
            {
                if (ContentString is not null)
                {
                    return ContentString;
                }
        
                if (ContentReference is not null)
                {
                    return ContentReference;
                }
        
                if (ContentAttachment is not null)
                {
                    return ContentAttachment;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ContentString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ContentReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    ContentAttachment = (Base.Attachment)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ContentString { get; set; }
        public Base.ResourceReference? ContentReference { get; set; }
        public Base.Attachment? ContentAttachment { get; set; }
    }
}