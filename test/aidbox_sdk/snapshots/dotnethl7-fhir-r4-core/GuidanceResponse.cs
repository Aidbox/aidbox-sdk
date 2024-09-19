using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class GuidanceResponse : DomainResource, IResource
{
    public Base.DataRequirement[]? DataRequirement { get; set; }
    public string? ModuleCanonical { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.ResourceReference? OutputParameters { get; set; }
    public Base.ResourceReference[]? EvaluationMessage { get; set; }
    public Base.Identifier? RequestIdentifier { get; set; }
    public object? Module    
    {
        get
        {
            if (ModuleCanonical is not null)
            {
                return ModuleCanonical;
            }
    
            if (ModuleCodeableConcept is not null)
            {
                return ModuleCodeableConcept;
            }
    
            if (ModuleUri is not null)
            {
                return ModuleUri;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                ModuleCanonical = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                ModuleCodeableConcept = (Base.CodeableConcept)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                ModuleUri = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Annotation[]? Note { get; set; }
    public required string Status { get; set; }
    public Base.ResourceReference? Result { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.CodeableConcept? ModuleCodeableConcept { get; set; }
    public string? ModuleUri { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference? Performer { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }
}