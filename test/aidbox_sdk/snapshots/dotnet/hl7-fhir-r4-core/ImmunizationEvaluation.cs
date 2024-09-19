using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class ImmunizationEvaluation : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public string? Description { get; set; }
    public string? SeriesDosesPositiveInt { get; set; }
    public string? Date { get; set; }
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
    public Base.ResourceReference? Authority { get; set; }
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
    public Base.CodeableConcept[]? DoseStatusReason { get; set; }
    public required Base.ResourceReference ImmunizationEvent { get; set; }
    public required string Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required Base.CodeableConcept TargetDisease { get; set; }
    public required Base.CodeableConcept DoseStatus { get; set; }
}