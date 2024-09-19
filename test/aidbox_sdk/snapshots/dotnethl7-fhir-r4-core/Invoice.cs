using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Invoice : DomainResource, IResource
{
    public string? Date { get; set; }
    public Base.Money? TotalNet { get; set; }
    public Base.ResourceReference? Recipient { get; set; }
    public Base.ResourceReference[]? TotalPriceComponent { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public Base.Money? TotalGross { get; set; }
    public Invoice_Participant[]? Participant { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? Account { get; set; }
    public required string Status { get; set; }
    public Invoice_LineItem[]? LineItem { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? Issuer { get; set; }
    public string? CancelledReason { get; set; }
    public string? PaymentTerms { get; set; }
    public Base.ResourceReference? Subject { get; set; }

    public class Invoice_Participant : BackboneElement
    {
        public Base.CodeableConcept? Role { get; set; }
        public required Base.ResourceReference Actor { get; set; }
    }

    public class Invoice_LineItem_PriceComponent : BackboneElement
    {
        public Base.CodeableConcept? Code { get; set; }
        public required string Type { get; set; }
        public Base.Money? Amount { get; set; }
        public string? Factor { get; set; }
    }

    public class Invoice_LineItem : BackboneElement
    {
        public string? Sequence { get; set; }
        public object? ChargeItem    
        {
            get
            {
                if (ChargeItemReference is not null)
                {
                    return ChargeItemReference;
                }
        
                if (ChargeItemCodeableConcept is not null)
                {
                    return ChargeItemCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ChargeItemReference = (Base.ResourceReference)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ChargeItemCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Invoice_LineItem_PriceComponent[]? PriceComponent { get; set; }
        public Base.ResourceReference? ChargeItemReference { get; set; }
        public Base.CodeableConcept? ChargeItemCodeableConcept { get; set; }
    }
}