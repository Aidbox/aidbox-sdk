using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class ObservationDefinition : DomainResource, IResource
{
    public ObservationDefinition_QuantitativeDetails? QuantitativeDetails { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.CodeableConcept? Method { get; set; }
    public Base.ResourceReference? ValidCodedValueSet { get; set; }
    public ObservationDefinition_QualifiedInterval[]? QualifiedInterval { get; set; }
    public Base.ResourceReference? AbnormalCodedValueSet { get; set; }
    public required Base.CodeableConcept Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string[]? PermittedDataType { get; set; }
    public bool? MultipleResultsAllowed { get; set; }
    public Base.ResourceReference? NormalCodedValueSet { get; set; }
    public string? PreferredReportName { get; set; }
    public Base.ResourceReference? CriticalCodedValueSet { get; set; }

    public class ObservationDefinition_QuantitativeDetails : BackboneElement
    {
        public Base.CodeableConcept? Unit { get; set; }
        public Base.CodeableConcept? CustomaryUnit { get; set; }
        public string? ConversionFactor { get; set; }
        public int? DecimalPrecision { get; set; }
    }

    public class ObservationDefinition_QualifiedInterval : BackboneElement
    {
        public Base.Range? Age { get; set; }
        public Base.Range? Range { get; set; }
        public string? Gender { get; set; }
        public Base.CodeableConcept? Context { get; set; }
        public string? Category { get; set; }
        public Base.CodeableConcept[]? AppliesTo { get; set; }
        public string? Condition { get; set; }
        public Base.Range? GestationalAge { get; set; }
    }
}