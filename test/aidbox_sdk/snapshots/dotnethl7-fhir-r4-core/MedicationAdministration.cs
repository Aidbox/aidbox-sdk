using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicationAdministration : DomainResource, IResource
{
    public Base.CodeableConcept? Category { get; set; }
    public Base.ResourceReference? Request { get; set; }
    public Base.ResourceReference[]? EventHistory { get; set; }
    public MedicationAdministration_Dosage? Dosage { get; set; }
    public string[]? Instantiates { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.CodeableConcept? MedicationCodeableConcept { get; set; }
    public Base.CodeableConcept[]? StatusReason { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference[]? SupportingInformation { get; set; }
    public string? EffectiveDateTime { get; set; }
    public required string Status { get; set; }
    public object? Effective    
    {
        get
        {
            if (EffectiveDateTime is not null)
            {
                return EffectiveDateTime;
            }
    
            if (EffectivePeriod is not null)
            {
                return EffectivePeriod;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                EffectiveDateTime = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                EffectivePeriod = (Base.Period)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? Context { get; set; }
    public Base.ResourceReference[]? Device { get; set; }
    public Base.ResourceReference? MedicationReference { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public MedicationAdministration_Performer[]? Performer { get; set; }
    public Base.Period? EffectivePeriod { get; set; }
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

    public class MedicationAdministration_Dosage : BackboneElement
    {
        public Base.Quantity? Dose { get; set; }
        public object? Rate    
        {
            get
            {
                if (RateRatio is not null)
                {
                    return RateRatio;
                }
        
                if (RateQuantity is not null)
                {
                    return RateQuantity;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    RateRatio = (Base.Ratio)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    RateQuantity = (Base.Quantity)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? Site { get; set; }
        public string? Text { get; set; }
        public Base.CodeableConcept? Route { get; set; }
        public Base.CodeableConcept? Method { get; set; }
        public Base.Ratio? RateRatio { get; set; }
        public Base.Quantity? RateQuantity { get; set; }
    }

    public class MedicationAdministration_Performer : BackboneElement
    {
        public required Base.ResourceReference Actor { get; set; }
        public Base.CodeableConcept? Function { get; set; }
    }
}