using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class DetectedIssue : DomainResource, IResource
{
    public Base.ResourceReference? Patient { get; set; }
    public DetectedIssue_Evidence[]? Evidence { get; set; }
    public DetectedIssue_Mitigation[]? Mitigation { get; set; }
    public Base.ResourceReference? Author { get; set; }
    public string? IdentifiedDateTime { get; set; }
    public string? Reference { get; set; }
    public required string Status { get; set; }
    public string? Severity { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public object? Identified    
    {
        get
        {
            if (IdentifiedDateTime is not null)
            {
                return IdentifiedDateTime;
            }
    
            if (IdentifiedPeriod is not null)
            {
                return IdentifiedPeriod;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                IdentifiedDateTime = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                IdentifiedPeriod = (Base.Period)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference[]? Implicated { get; set; }
    public Base.Period? IdentifiedPeriod { get; set; }
    public string? Detail { get; set; }

    public class DetectedIssue_Evidence : BackboneElement
    {
        public Base.CodeableConcept[]? Code { get; set; }
        public Base.ResourceReference[]? Detail { get; set; }
    }

    public class DetectedIssue_Mitigation : BackboneElement
    {
        public string? Date { get; set; }
        public required Base.CodeableConcept Action { get; set; }
        public Base.ResourceReference? Author { get; set; }
    }
}