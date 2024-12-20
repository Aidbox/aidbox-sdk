using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class GraphDefinition : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public string? Publisher { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public required string Name { get; set; }
    public required string Start { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public bool? Experimental { get; set; }
    public required string Status { get; set; }
    public GraphDefinition_Link[]? Link { get; set; }
    public string? Url { get; set; }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }
    public string? Profile { get; set; }

    public class GraphDefinition_Link_Target_Link_Target_Compartment : BackboneElement
    {
        public required string Use { get; set; }
        public required string Code { get; set; }
        public required string Rule { get; set; }
        public string? Expression { get; set; }
        public string? Description { get; set; }
    }

    public class GraphDefinition_Link_Target_Link_Target : BackboneElement
    {
        public string[]? Link { get; set; }
        public required string Type { get; set; }
        public string? Params { get; set; }
        public string? Profile { get; set; }
        public GraphDefinition_Link_Target_Link_Target_Compartment[]? Compartment { get; set; }
    }

    public class GraphDefinition_Link_Target_Link : BackboneElement
    {
        public string? Max { get; set; }
        public int? Min { get; set; }
        public string? Path { get; set; }
        public GraphDefinition_Link_Target_Link_Target[]? Target { get; set; }
        public string? SliceName { get; set; }
        public string? Description { get; set; }
    }

    public class GraphDefinition_Link_Target_Compartment : BackboneElement
    {
        public required string Use { get; set; }
        public required string Code { get; set; }
        public required string Rule { get; set; }
        public string? Expression { get; set; }
        public string? Description { get; set; }
    }

    public class GraphDefinition_Link_Target : BackboneElement
    {
        public GraphDefinition_Link_Target_Link[]? Link { get; set; }
        public required string Type { get; set; }
        public string? Params { get; set; }
        public string? Profile { get; set; }
        public GraphDefinition_Link_Target_Compartment[]? Compartment { get; set; }
    }

    public class GraphDefinition_Link : BackboneElement
    {
        public string? Max { get; set; }
        public int? Min { get; set; }
        public string? Path { get; set; }
        public GraphDefinition_Link_Target[]? Target { get; set; }
        public string? SliceName { get; set; }
        public string? Description { get; set; }
    }
}