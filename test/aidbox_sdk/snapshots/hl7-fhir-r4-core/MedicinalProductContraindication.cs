using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicinalProductContraindication : DomainResource, IResource
{
    public Base.CodeableConcept? Disease { get; set; }
    public Base.ResourceReference[]? Subject { get; set; }
    public Base.Population[]? Population { get; set; }
    public Base.CodeableConcept[]? Comorbidity { get; set; }
    public MedicinalProductContraindication_OtherTherapy[]? OtherTherapy { get; set; }
    public Base.CodeableConcept? DiseaseStatus { get; set; }
    public Base.ResourceReference[]? TherapeuticIndication { get; set; }

    public class MedicinalProductContraindication_OtherTherapy : BackboneElement
    {
        public object? Medication    
        {
            get
            {
                if (MedicationReference is not null)
                {
                    return MedicationReference;
                }
        
                if (MedicationCodeableConcept is not null)
                {
                    return MedicationCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    MedicationReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    MedicationCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? MedicationReference { get; set; }
        public required Base.CodeableConcept TherapyRelationshipType { get; set; }
        public Base.CodeableConcept? MedicationCodeableConcept { get; set; }
    }
}