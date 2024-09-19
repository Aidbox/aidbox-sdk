using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class OrganizationAffiliation : DomainResource, IResource
{
    public Base.CodeableConcept[]? Specialty { get; set; }
    public Base.ResourceReference? Organization { get; set; }
    public Base.ResourceReference? ParticipatingOrganization { get; set; }
    public bool? Active { get; set; }
    public Base.CodeableConcept[]? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ContactPoint[]? Telecom { get; set; }
    public Base.ResourceReference[]? Network { get; set; }
    public Base.Period? Period { get; set; }
    public Base.ResourceReference[]? Location { get; set; }
    public Base.ResourceReference[]? Endpoint { get; set; }
    public Base.ResourceReference[]? HealthcareService { get; set; }
}