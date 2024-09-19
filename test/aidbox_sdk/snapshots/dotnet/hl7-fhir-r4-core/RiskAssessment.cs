using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class RiskAssessment : DomainResource, IResource
{
    public Base.ResourceReference? Parent { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public RiskAssessment_Prediction[]? Prediction { get; set; }
    public Base.CodeableConcept? Method { get; set; }
    public Base.ResourceReference[]? Basis { get; set; }
    public Base.CodeableConcept[]? ReasonCode { get; set; }
    public string? Mitigation { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.Period? OccurrencePeriod { get; set; }
    public required string Status { get; set; }
    public Base.ResourceReference? Condition { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? BasedOn { get; set; }
    public string? OccurrenceDateTime { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public object? Occurrence    
    {
        get
        {
            if (OccurrencePeriod is not null)
            {
                return OccurrencePeriod;
            }
    
            if (OccurrenceDateTime is not null)
            {
                return OccurrenceDateTime;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Period))
            {
                OccurrencePeriod = (Base.Period)value;return;
            }
    
            if (value?.GetType() == typeof(string))
            {
                OccurrenceDateTime = (string)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.ResourceReference? Performer { get; set; }
    public Base.ResourceReference[]? ReasonReference { get; set; }

    public class RiskAssessment_Prediction : BackboneElement
    {
        public string? RelativeRisk { get; set; }
        public object? When    
        {
            get
            {
                if (WhenRange is not null)
                {
                    return WhenRange;
                }
        
                if (WhenPeriod is not null)
                {
                    return WhenPeriod;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    WhenRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Period))
                {
                    WhenPeriod = (Base.Period)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Range? WhenRange { get; set; }
        public Base.CodeableConcept? Outcome { get; set; }
        public object? Probability    
        {
            get
            {
                if (ProbabilityRange is not null)
                {
                    return ProbabilityRange;
                }
        
                if (ProbabilityDecimal is not null)
                {
                    return ProbabilityDecimal;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    ProbabilityRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ProbabilityDecimal = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Period? WhenPeriod { get; set; }
        public string? Rationale { get; set; }
        public Base.Range? ProbabilityRange { get; set; }
        public Base.CodeableConcept? QualitativeRisk { get; set; }
        public string? ProbabilityDecimal { get; set; }
    }
}