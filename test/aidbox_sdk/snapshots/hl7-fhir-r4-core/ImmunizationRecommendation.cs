using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ImmunizationRecommendation : DomainResource, IResource
{
    public required string Date { get; set; }
    public required Base.ResourceReference Patient { get; set; }
    public Base.ResourceReference? Authority { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required ImmunizationRecommendation_Recommendation[] Recommendation { get; set; }

    public class ImmunizationRecommendation_Recommendation_DateCriterion : BackboneElement
    {
        public required Base.CodeableConcept Code { get; set; }
        public required string Value { get; set; }
    }

    public class ImmunizationRecommendation_Recommendation : BackboneElement
    {
        public string? Description { get; set; }
        public string? SeriesDosesPositiveInt { get; set; }
        public Base.CodeableConcept[]? ContraindicatedVaccineCode { get; set; }
        public string? DoseNumberPositiveInt { get; set; }
        public string? Series { get; set; }
        public object? DoseNumber    
        {
            get
            {
                if (DoseNumberPositiveInt is not null)
                {
                    return DoseNumberPositiveInt;
                }
        
                if (DoseNumberString is not null)
                {
                    return DoseNumberString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    DoseNumberPositiveInt = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DoseNumberString = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept[]? VaccineCode { get; set; }
        public string? DoseNumberString { get; set; }
        public string? SeriesDosesString { get; set; }
        public object? SeriesDoses    
        {
            get
            {
                if (SeriesDosesPositiveInt is not null)
                {
                    return SeriesDosesPositiveInt;
                }
        
                if (SeriesDosesString is not null)
                {
                    return SeriesDosesString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    SeriesDosesPositiveInt = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    SeriesDosesString = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public required Base.CodeableConcept ForecastStatus { get; set; }
        public Base.CodeableConcept[]? ForecastReason { get; set; }
        public ImmunizationRecommendation_Recommendation_DateCriterion[]? DateCriterion { get; set; }
        public Base.CodeableConcept? TargetDisease { get; set; }
        public Base.ResourceReference[]? SupportingImmunization { get; set; }
        public Base.ResourceReference[]? SupportingPatientInformation { get; set; }
    }
}