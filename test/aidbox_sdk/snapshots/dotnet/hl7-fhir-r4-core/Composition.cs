using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Composition : DomainResource, IResource
{
    public Base.CodeableConcept[]? Category { get; set; }
    public required string Date { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Composition_Section[]? Section { get; set; }
    public Composition_Attester[]? Attester { get; set; }
    public required Base.CodeableConcept Type { get; set; }
    public required string Title { get; set; }
    public required Base.ResourceReference[] Author { get; set; }
    public Composition_Event[]? Event { get; set; }
    public Base.ResourceReference? Custodian { get; set; }
    public required string Status { get; set; }
    public Base.Identifier? Identifier { get; set; }
    public Composition_RelatesTo[]? RelatesTo { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public string? Confidentiality { get; set; }

    public class Composition_Section_Section : BackboneElement
    {
        public Base.CodeableConcept? OrderedBy { get; set; }
        public string[]? Section { get; set; }
        public string? Mode { get; set; }
        public string? Title { get; set; }
        public Base.CodeableConcept? EmptyReason { get; set; }
        public Base.ResourceReference[]? Author { get; set; }
        public Base.CodeableConcept? Code { get; set; }
        public Base.ResourceReference? Focus { get; set; }
        public Base.ResourceReference[]? Entry { get; set; }
        public Base.Narrative? Text { get; set; }
    }

    public class Composition_Section : BackboneElement
    {
        public Base.CodeableConcept? OrderedBy { get; set; }
        public Composition_Section_Section[]? Section { get; set; }
        public string? Mode { get; set; }
        public string? Title { get; set; }
        public Base.CodeableConcept? EmptyReason { get; set; }
        public Base.ResourceReference[]? Author { get; set; }
        public Base.CodeableConcept? Code { get; set; }
        public Base.ResourceReference? Focus { get; set; }
        public Base.ResourceReference[]? Entry { get; set; }
        public Base.Narrative? Text { get; set; }
    }

    public class Composition_Attester : BackboneElement
    {
        public required string Mode { get; set; }
        public string? Time { get; set; }
        public Base.ResourceReference? Party { get; set; }
    }

    public class Composition_Event : BackboneElement
    {
        public Base.CodeableConcept[]? Code { get; set; }
        public Base.ResourceReference[]? Detail { get; set; }
        public Base.Period? Period { get; set; }
    }

    public class Composition_RelatesTo : BackboneElement
    {
        public required string Code { get; set; }
        public object? Target    
        {
            get
            {
                if (TargetReference is not null)
                {
                    return TargetReference;
                }
        
                if (TargetIdentifier is not null)
                {
                    return TargetIdentifier;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    TargetReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Identifier))
                {
                    TargetIdentifier = (Base.Identifier)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? TargetReference { get; set; }
        public Base.Identifier? TargetIdentifier { get; set; }
    }
}