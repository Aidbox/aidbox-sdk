using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicationStatement : DomainResource, IResource
{
    public Base.CodeableConcept? Category { get; set; }
    public string[]? Dosage { get; set; }
    public Base.ResourceReference[]? DerivedFrom { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public Base.CodeableConcept? MedicationCodeableConcept { get; set; }
    public Base.CodeableConcept[]? StatusReason { get; set; }
    public Base.Annotation[]? Note { get; set; }
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
    public string? DateAsserted { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference? MedicationReference { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public Base.ResourceReference? InformationSource { get; set; }
    public required Base.ResourceReference Subject { get; set; }
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
}