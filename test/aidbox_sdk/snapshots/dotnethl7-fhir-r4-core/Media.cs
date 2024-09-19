using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Media : DomainResource, IResource
{
    public string? DeviceName { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public required Base.Attachment Content { get; set; }
    public string? Frames { get; set; }
    public string? Width { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public object? Created    
    {
        get
        {
            if (CreatedPeriod is not null)
            {
                return CreatedPeriod;
            }
    
            if (CreatedDateTime is not null)
            {
                return CreatedDateTime;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Period))
            {
                CreatedPeriod = (Base.Period)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                CreatedDateTime = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept? Modality { get; set; }
    public string? Duration { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.Period? CreatedPeriod { get; set; }
    public required string Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? Operator { get; set; }
    public Base.CodeableConcept? BodySite { get; set; }
    public string? Issued { get; set; }
    public Base.ResourceReference? Device { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public string? CreatedDateTime { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.CodeableConcept? View { get; set; }
    public string? Height { get; set; }
}