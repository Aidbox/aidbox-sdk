using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class NutritionOrder : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public NutritionOrder_OralDiet? OralDiet { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public string[]? Instantiates { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public required string DateTime { get; set; }
    public NutritionOrder_EnteralFormula? EnteralFormula { get; set; }
    public Base.CodeableConcept[]? FoodPreferenceModifier { get; set; }
    public required string Status { get; set; }
    public Base.CodeableConcept[]? ExcludeFoodModifier { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required string Intent { get; set; }
    public Base.ResourceReference? Orderer { get; set; }
    public NutritionOrder_Supplement[]? Supplement { get; set; }
    public Base.ResourceReference[]? AllergyIntolerance { get; set; }

    public class NutritionOrder_OralDiet_Texture : BackboneElement
    {
        public Base.CodeableConcept? FoodType { get; set; }
        public Base.CodeableConcept? Modifier { get; set; }
    }

    public class NutritionOrder_OralDiet_Nutrient : BackboneElement
    {
        public Base.Quantity? Amount { get; set; }
        public Base.CodeableConcept? Modifier { get; set; }
    }

    public class NutritionOrder_OralDiet : BackboneElement
    {
        public Base.CodeableConcept[]? Type { get; set; }
        public NutritionOrder_OralDiet_Texture[]? Texture { get; set; }
        public NutritionOrder_OralDiet_Nutrient[]? Nutrient { get; set; }
        public string[]? Schedule { get; set; }
        public string? Instruction { get; set; }
        public Base.CodeableConcept[]? FluidConsistencyType { get; set; }
    }

    public class NutritionOrder_EnteralFormula_Administration : BackboneElement
    {
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
        public Base.Quantity? Quantity { get; set; }
        public string? Schedule { get; set; }
        public Base.Ratio? RateRatio { get; set; }
        public Base.Quantity? RateQuantity { get; set; }
    }

    public class NutritionOrder_EnteralFormula : BackboneElement
    {
        public Base.CodeableConcept? AdditiveType { get; set; }
        public Base.Quantity? MaxVolumeToDeliver { get; set; }
        public Base.CodeableConcept? BaseFormulaType { get; set; }
        public Base.CodeableConcept? RouteofAdministration { get; set; }
        public string? AdditiveProductName { get; set; }
        public Base.Quantity? CaloricDensity { get; set; }
        public string? AdministrationInstruction { get; set; }
        public NutritionOrder_EnteralFormula_Administration[]? Administration { get; set; }
        public string? BaseFormulaProductName { get; set; }
    }

    public class NutritionOrder_Supplement : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public string[]? Schedule { get; set; }
        public string? Instruction { get; set; }
        public string? ProductName { get; set; }
    }
}