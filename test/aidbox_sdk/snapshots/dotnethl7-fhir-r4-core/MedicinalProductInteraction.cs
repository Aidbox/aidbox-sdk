using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicinalProductInteraction : DomainResource, IResource
{
    public Base.CodeableConcept? Type { get; set; }
    public Base.CodeableConcept? Effect { get; set; }
    public Base.ResourceReference[]? Subject { get; set; }
    public Base.CodeableConcept? Incidence { get; set; }
    public Base.CodeableConcept? Management { get; set; }
    public string? Description { get; set; }
    public MedicinalProductInteraction_Interactant[]? Interactant { get; set; }

    public class MedicinalProductInteraction_Interactant : BackboneElement
    {
        public object? Item    
        {
            get
            {
                if (ItemReference is not null)
                {
                    return ItemReference;
                }
        
                if (ItemCodeableConcept is not null)
                {
                    return ItemCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ItemReference = (Base.ResourceReference)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ItemCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? ItemReference { get; set; }
        public Base.CodeableConcept? ItemCodeableConcept { get; set; }
    }
}