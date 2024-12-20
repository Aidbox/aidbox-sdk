using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class ChargeItemDefinition : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public string? Publisher { get; set; }
    public string? ApprovalDate { get; set; }
    public ChargeItemDefinition_PropertyGroup[]? PropertyGroup { get; set; }
    public Base.ResourceReference[]? Instance { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public string? Title { get; set; }
    public string[]? DerivedFromUri { get; set; }
    public required string Status { get; set; }
    public required string Url { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? LastReviewDate { get; set; }
    public string[]? Replaces { get; set; }
    public string[]? PartOf { get; set; }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }
    public ChargeItemDefinition_Applicability[]? Applicability { get; set; }
    public Base.Period? EffectivePeriod { get; set; }

    public class ChargeItemDefinition_PropertyGroup_Applicability : BackboneElement
    {
        public string? Language { get; set; }
        public string? Expression { get; set; }
        public string? Description { get; set; }
    }

    public class ChargeItemDefinition_PropertyGroup_PriceComponent : BackboneElement
    {
        public Base.CodeableConcept? Code { get; set; }
        public required string Type { get; set; }
        public Base.Money? Amount { get; set; }
        public string? Factor { get; set; }
    }

    public class ChargeItemDefinition_PropertyGroup : BackboneElement
    {
        public ChargeItemDefinition_PropertyGroup_Applicability[]? Applicability { get; set; }
        public ChargeItemDefinition_PropertyGroup_PriceComponent[]? PriceComponent { get; set; }
    }

    public class ChargeItemDefinition_Applicability : BackboneElement
    {
        public string? Language { get; set; }
        public string? Expression { get; set; }
        public string? Description { get; set; }
    }
}