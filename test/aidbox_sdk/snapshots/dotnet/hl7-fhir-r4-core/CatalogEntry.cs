using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class CatalogEntry : DomainResource, IResource
{
    public Base.CodeableConcept[]? AdditionalCharacteristic { get; set; }
    public Base.CodeableConcept[]? AdditionalClassification { get; set; }
    public required Base.ResourceReference ReferencedItem { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public Base.CodeableConcept[]? Classification { get; set; }
    public Base.Period? ValidityPeriod { get; set; }
    public required bool Orderable { get; set; }
    public string? Status { get; set; }
    public string? ValidTo { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.Identifier[]? AdditionalIdentifier { get; set; }
    public string? LastUpdated { get; set; }
    public CatalogEntry_RelatedEntry[]? RelatedEntry { get; set; }

    public class CatalogEntry_RelatedEntry : BackboneElement
    {
        public required Base.ResourceReference Item { get; set; }
        public required string Relationtype { get; set; }
    }
}