using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class ConceptMap : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? SourceCanonical { get; set; }
    public string? Date { get; set; }
    public string? TargetUri { get; set; }
    public ConceptMap_Group[]? Group { get; set; }
    public string? Publisher { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public string? Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public object? Source    
    {
        get
        {
            if (SourceCanonical is not null)
            {
                return SourceCanonical;
            }
    
            if (SourceUri is not null)
            {
                return SourceUri;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                SourceCanonical = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                SourceUri = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public string? Title { get; set; }
    public string? TargetCanonical { get; set; }
    public required string Status { get; set; }
    public string? SourceUri { get; set; }
    public string? Url { get; set; }
    public Base.Identifier? Identifier { get; set; }
    public object? Target    
    {
        get
        {
            if (TargetUri is not null)
            {
                return TargetUri;
            }
    
            if (TargetCanonical is not null)
            {
                return TargetCanonical;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                TargetUri = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                TargetCanonical = (string)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }

    public class ConceptMap_Group_Element_Target_DependsOn : BackboneElement
    {
        public required string Value { get; set; }
        public string? System { get; set; }
        public string? Display { get; set; }
        public required string Property { get; set; }
    }

    public class ConceptMap_Group_Element_Target : BackboneElement
    {
        public string? Code { get; set; }
        public string? Comment { get; set; }
        public string? Display { get; set; }
        public Base.ResourceReference[]? Product { get; set; }
        public ConceptMap_Group_Element_Target_DependsOn[]? DependsOn { get; set; }
        public required string Equivalence { get; set; }
    }

    public class ConceptMap_Group_Element : BackboneElement
    {
        public string? Code { get; set; }
        public ConceptMap_Group_Element_Target[]? Target { get; set; }
        public string? Display { get; set; }
    }

    public class ConceptMap_Group_Unmapped : BackboneElement
    {
        public string? Url { get; set; }
        public string? Code { get; set; }
        public required string Mode { get; set; }
        public string? Display { get; set; }
    }

    public class ConceptMap_Group : BackboneElement
    {
        public string? Source { get; set; }
        public string? Target { get; set; }
        public required ConceptMap_Group_Element[] Element { get; set; }
        public ConceptMap_Group_Unmapped? Unmapped { get; set; }
        public string? SourceVersion { get; set; }
        public string? TargetVersion { get; set; }
    }
}