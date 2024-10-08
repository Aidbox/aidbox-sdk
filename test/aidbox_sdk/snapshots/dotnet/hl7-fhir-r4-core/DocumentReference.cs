using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class DocumentReference : DomainResource, IResource
{
    public string? Description { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public string? Date { get; set; }
    public string? DocStatus { get; set; }
    public required DocumentReference_Content[] Content { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public Base.ResourceReference[]? Author { get; set; }
    public Base.Identifier? MasterIdentifier { get; set; }
    public Base.ResourceReference? Custodian { get; set; }
    public required string Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public DocumentReference_RelatesTo[]? RelatesTo { get; set; }
    public DocumentReference_Context? Context { get; set; }
    public Base.CodeableConcept[]? SecurityLabel { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference? Authenticator { get; set; }

    public class DocumentReference_Content : BackboneElement
    {
        public Base.Coding? Format { get; set; }
        public required Base.Attachment Attachment { get; set; }
    }

    public class DocumentReference_RelatesTo : BackboneElement
    {
        public required string Code { get; set; }
        public required Base.ResourceReference Target { get; set; }
    }

    public class DocumentReference_Context : BackboneElement
    {
        public Base.CodeableConcept[]? Event { get; set; }
        public Base.Period? Period { get; set; }
        public Base.ResourceReference[]? Related { get; set; }
        public Base.ResourceReference[]? Encounter { get; set; }
        public Base.CodeableConcept? FacilityType { get; set; }
        public Base.CodeableConcept? PracticeSetting { get; set; }
        public Base.ResourceReference? SourcePatientInfo { get; set; }
    }
}