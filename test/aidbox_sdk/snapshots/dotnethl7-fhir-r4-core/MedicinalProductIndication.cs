using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicinalProductIndication : DomainResource, IResource
{
    public Base.CodeableConcept? DiseaseSymptomProcedure { get; set; }
    public Base.ResourceReference[]? UndesirableEffect { get; set; }
    public Base.Quantity? Duration { get; set; }
    public MedicinalProductIndication_OtherTherapy[]? OtherTherapy { get; set; }
    public Base.CodeableConcept[]? Comorbidity { get; set; }
    public Base.CodeableConcept? IntendedEffect { get; set; }
    public Base.Population[]? Population { get; set; }
    public Base.CodeableConcept? DiseaseStatus { get; set; }
    public Base.ResourceReference[]? Subject { get; set; }

    public class MedicinalProductIndication_OtherTherapy : BackboneElement
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
                    MedicationReference = (Base.ResourceReference)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    MedicationCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? MedicationReference { get; set; }
        public required Base.CodeableConcept TherapyRelationshipType { get; set; }
        public Base.CodeableConcept? MedicationCodeableConcept { get; set; }
    }
}