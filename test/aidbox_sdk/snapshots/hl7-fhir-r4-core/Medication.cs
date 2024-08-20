using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class Medication : DomainResource, IResource
{
    public Base.CodeableConcept? Code { get; set; }
    public Base.CodeableConcept? Form { get; set; }
    public Medication_Batch? Batch { get; set; }
    public Base.Ratio? Amount { get; set; }
    public string? Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Medication_Ingredient[]? Ingredient { get; set; }
    public Base.ResourceReference? Manufacturer { get; set; }

    public class Medication_Batch : BackboneElement
    {
        public string? LotNumber { get; set; }
        public string? ExpirationDate { get; set; }
    }

    public class Medication_Ingredient : BackboneElement
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
                    ItemReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ItemCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public bool? IsActive { get; set; }
        public Base.Ratio? Strength { get; set; }
        public Base.ResourceReference? ItemReference { get; set; }
        public Base.CodeableConcept? ItemCodeableConcept { get; set; }
    }
}