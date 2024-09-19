using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Coverage : DomainResource, IResource
{
    public Base.ResourceReference? PolicyHolder { get; set; }
    public required Base.ResourceReference Beneficiary { get; set; }
    public Base.ResourceReference[]? Contract { get; set; }
    public Base.CodeableConcept? Relationship { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public Coverage_CostToBeneficiary[]? CostToBeneficiary { get; set; }
    public bool? Subrogation { get; set; }
    public Base.ResourceReference? Subscriber { get; set; }
    public required Base.ResourceReference[] Payor { get; set; }
    public required string Status { get; set; }
    public Coverage_Class[]? Class_ { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? Order { get; set; }
    public string? Network { get; set; }
    public Base.Period? Period { get; set; }
    public string? Dependent { get; set; }
    public string? SubscriberId { get; set; }

    public class Coverage_CostToBeneficiary_Exception : BackboneElement
    {
        public required Base.CodeableConcept Type { get; set; }
        public Base.Period? Period { get; set; }
    }

    public class Coverage_CostToBeneficiary : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueMoney is not null)
                {
                    return ValueMoney;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Money))
                {
                    ValueMoney = (Base.Money)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Coverage_CostToBeneficiary_Exception[]? Exception { get; set; }
        public Base.Money? ValueMoney { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
    }

    public class Coverage_Class : BackboneElement
    {
        public string? Name { get; set; }
        public required Base.CodeableConcept Type { get; set; }
        public required string Value { get; set; }
    }
}