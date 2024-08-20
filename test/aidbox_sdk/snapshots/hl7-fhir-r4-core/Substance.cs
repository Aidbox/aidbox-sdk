using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Substance : DomainResource, IResource
{
    public required Base.CodeableConcept Code { get; set; }
    public string? Status { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public Substance_Instance[]? Instance { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Substance_Ingredient[]? Ingredient { get; set; }
    public string? Description { get; set; }

    public class Substance_Instance : BackboneElement
    {
        public string? Expiry { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.Identifier? Identifier { get; set; }
    }

    public class Substance_Ingredient : BackboneElement
    {
        public Base.Ratio? Quantity { get; set; }
        public object? Substance    
        {
            get
            {
                if (SubstanceReference is not null)
                {
                    return SubstanceReference;
                }
        
                if (SubstanceCodeableConcept is not null)
                {
                    return SubstanceCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    SubstanceReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    SubstanceCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? SubstanceReference { get; set; }
        public Base.CodeableConcept? SubstanceCodeableConcept { get; set; }
    }
}