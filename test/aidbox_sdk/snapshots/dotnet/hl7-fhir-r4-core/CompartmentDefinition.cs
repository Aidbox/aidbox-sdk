using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class CompartmentDefinition : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public string? Publisher { get; set; }
    public string? Purpose { get; set; }
    public required string Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public bool? Experimental { get; set; }
    public required bool Search { get; set; }
    public required string Status { get; set; }
    public CompartmentDefinition_Resource[]? Resource { get; set; }
    public required string Url { get; set; }
    public required string Code { get; set; }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }

    public class CompartmentDefinition_Resource : BackboneElement
    {
        public required string Code { get; set; }
        public string[]? Param { get; set; }
        public string? Documentation { get; set; }
    }
}