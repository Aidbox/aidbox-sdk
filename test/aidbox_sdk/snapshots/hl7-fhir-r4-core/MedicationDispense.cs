using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class MedicationDispense : DomainResource, IResource
{
    public Base.ResourceReference? StatusReasonReference { get; set; }
    public Base.CodeableConcept? Category { get; set; }
    public string? WhenHandedOver { get; set; }
    public string? WhenPrepared { get; set; }
    public Base.ResourceReference[]? EventHistory { get; set; }
    public MedicationDispense_Substitution? Substitution { get; set; }
    public Base.ResourceReference[]? DetectedIssue { get; set; }
    public Base.CodeableConcept? MedicationCodeableConcept { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public object? StatusReason    
    {
        get
        {
            if (StatusReasonReference is not null)
            {
                return StatusReasonReference;
            }
    
            if (StatusReasonCodeableConcept is not null)
            {
                return StatusReasonCodeableConcept;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                StatusReasonReference = (Base.ResourceReference)value;return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                StatusReasonCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Annotation[]? Note { get; set; }
    public Base.CodeableConcept? StatusReasonCodeableConcept { get; set; }
    public Base.ResourceReference[]? SupportingInformation { get; set; }
    public required string Status { get; set; }
    public string[]? DosageInstruction { get; set; }
    public Base.Quantity? DaysSupply { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? Context { get; set; }
    public Base.ResourceReference? MedicationReference { get; set; }
    public Base.Quantity? Quantity { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public Base.ResourceReference? Location { get; set; }
    public Base.ResourceReference[]? AuthorizingPrescription { get; set; }
    public Base.ResourceReference[]? Receiver { get; set; }
    public Base.ResourceReference? Subject { get; set; }
    public Base.ResourceReference? Destination { get; set; }
    public MedicationDispense_Performer[]? Performer { get; set; }
    public object? Medication    
    {
        get
        {
            if (MedicationCodeableConcept is not null)
            {
                return MedicationCodeableConcept;
            }
    
            if (MedicationReference is not null)
            {
                return MedicationReference;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                MedicationCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                MedicationReference = (Base.ResourceReference)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }

    public class MedicationDispense_Substitution : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.CodeableConcept[]? Reason { get; set; }
        public required bool WasSubstituted { get; set; }
        public Base.ResourceReference[]? ResponsibleParty { get; set; }
    }

    public class MedicationDispense_Performer : BackboneElement
    {
        public required Base.ResourceReference Actor { get; set; }
        public Base.CodeableConcept? Function { get; set; }
    }
}