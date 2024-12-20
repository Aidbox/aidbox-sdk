using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Slot : DomainResource, IResource
{
    public required Base.ResourceReference Schedule { get; set; }
    public Base.CodeableConcept[]? ServiceCategory { get; set; }
    public Base.CodeableConcept[]? Specialty { get; set; }
    public required string Start { get; set; }
    public Base.CodeableConcept[]? ServiceType { get; set; }
    public Base.CodeableConcept? AppointmentType { get; set; }
    public required string Status { get; set; }
    public string? Comment { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required string End { get; set; }
    public bool? Overbooked { get; set; }
}