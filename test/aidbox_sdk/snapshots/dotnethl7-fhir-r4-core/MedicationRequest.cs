using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicationRequest : DomainResource, IResource
{
    public Base.CodeableConcept? PerformerType { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.ResourceReference[]? Insurance { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public Base.ResourceReference[]? EventHistory { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public MedicationRequest_Substitution? Substitution { get; set; }
    public Base.ResourceReference[]? DetectedIssue { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public MedicationRequest_DispenseRequest? DispenseRequest { get; set; }
    public object? Reported    
    {
        get
        {
            if (ReportedReference is not null)
            {
                return ReportedReference;
            }
    
            if (ReportedBoolean is not null)
            {
                return ReportedBoolean;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                ReportedReference = (Base.ResourceReference)value;
                return;
            }
    
            if (value?.GetType() == typeof(bool))
            {
                ReportedBoolean = (bool)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.CodeableConcept? MedicationCodeableConcept { get; set; }
    public Base.CodeableConcept? StatusReason { get; set; }
    public string? AuthoredOn { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? Requester { get; set; }
    public Base.ResourceReference[]? SupportingInformation { get; set; }
    public Base.ResourceReference? ReportedReference { get; set; }
    public string? Priority { get; set; }
    public required string Status { get; set; }
    public string[]? DosageInstruction { get; set; }
    public Base.Identifier? GroupIdentifier { get; set; }
    public Base.ResourceReference? Recorder { get; set; }
    public bool? ReportedBoolean { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public bool? DoNotPerform { get; set; }
    public required string Intent { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference? PriorPrescription { get; set; }
    public Base.ResourceReference? MedicationReference { get; set; }
    public Base.CodeableConcept? CourseOfTherapyType { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public Base.ResourceReference? Performer { get; set; }
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
                MedicationCodeableConcept = (Base.CodeableConcept)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                MedicationReference = (Base.ResourceReference)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class MedicationRequest_Substitution : BackboneElement
    {
        public Base.CodeableConcept? Reason { get; set; }
        public object? Allowed    
        {
            get
            {
                if (AllowedBoolean is not null)
                {
                    return AllowedBoolean;
                }
        
                if (AllowedCodeableConcept is not null)
                {
                    return AllowedCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(bool))
                {
                    AllowedBoolean = (bool)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    AllowedCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public bool? AllowedBoolean { get; set; }
        public Base.CodeableConcept? AllowedCodeableConcept { get; set; }
    }

    public class MedicationRequest_DispenseRequest_InitialFill : BackboneElement
    {
        public string? Duration { get; set; }
        public Base.Quantity? Quantity { get; set; }
    }

    public class MedicationRequest_DispenseRequest : BackboneElement
    {
        public Base.Quantity? Quantity { get; set; }
        public Base.ResourceReference? Performer { get; set; }
        public MedicationRequest_DispenseRequest_InitialFill? InitialFill { get; set; }
        public Base.Period? ValidityPeriod { get; set; }
        public string? DispenseInterval { get; set; }
        public string? ExpectedSupplyDuration { get; set; }
        public uint? NumberOfRepeatsAllowed { get; set; }
    }
}