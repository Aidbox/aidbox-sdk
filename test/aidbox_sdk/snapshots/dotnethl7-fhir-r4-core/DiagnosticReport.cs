using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class DiagnosticReport : DomainResource, IResource
{
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.CodeableConcept[]? ConclusionCode { get; set; }
    public string? Conclusion { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.ResourceReference[]? Specimen { get; set; }
    public string? EffectiveDateTime { get; set; }
    public Base.ResourceReference[]? ResultsInterpreter { get; set; }
    public required string Status { get; set; }
    public Base.ResourceReference[]? Result { get; set; }
    public object? Effective    
    {
        get
        {
            if (EffectiveDateTime is not null)
            {
                return EffectiveDateTime;
            }
    
            if (EffectivePeriod is not null)
            {
                return EffectivePeriod;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                EffectiveDateTime = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                EffectivePeriod = (Base.Period)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public required Base.CodeableConcept Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? Issued { get; set; }
    public Base.Attachment[]? PresentedForm { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference[]? ImagingStudy { get; set; }
    public DiagnosticReport_Media[]? Media { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference[]? Performer { get; set; }
    public Base.Period? EffectivePeriod { get; set; }

    public class DiagnosticReport_Media : BackboneElement
    {
        public required Base.ResourceReference Link { get; set; }
        public string? Comment { get; set; }
    }
}