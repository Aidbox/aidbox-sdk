using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class Communication : DomainResource, IResource
{
    public Base.CodeableConcept[]? Category { get; set; }
    public string? Received { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public Communication_Payload[]? Payload { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.CodeableConcept[]? Medium { get; set; }
    public Base.ResourceReference[]? Recipient { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.CodeableConcept? StatusReason { get; set; }
    public Base.CodeableConcept? Topic { get; set; }
    public string? Sent { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public string? Priority { get; set; }
    public required string Status { get; set; }
    public Base.ResourceReference? Sender { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference[]? InResponseTo { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference[]? About { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class Communication_Payload : BackboneElement
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