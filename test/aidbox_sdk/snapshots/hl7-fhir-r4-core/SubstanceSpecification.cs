using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class SubstanceSpecification : DomainResource, IResource
{
    public string? Description { get; set; }
    public SubstanceSpecification_Property[]? Property { get; set; }
    public SubstanceSpecification_Name[]? Name { get; set; }
    public Base.ResourceReference? ReferenceInformation { get; set; }
    public SubstanceSpecification_Relationship[]? Relationship { get; set; }
    public Base.CodeableConcept? Type { get; set; }
    public SubstanceSpecification_Moiety[]? Moiety { get; set; }
    public Base.ResourceReference[]? Source { get; set; }
    public Base.ResourceReference? NucleicAcid { get; set; }
    public SubstanceSpecification_Structure? Structure { get; set; }
    public Base.CodeableConcept? Status { get; set; }
    public string? Comment { get; set; }
    public SubstanceSpecification_Code[]? Code { get; set; }
    public Base.Identifier? Identifier { get; set; }
    public SubstanceSpecification_MolecularWeight[]? MolecularWeight { get; set; }
    public Base.ResourceReference? Polymer { get; set; }
    public Base.ResourceReference? Protein { get; set; }
    public Base.CodeableConcept? Domain { get; set; }
    public Base.ResourceReference? SourceMaterial { get; set; }

    public class SubstanceSpecification_Property : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public object? Amount    
        {
            get
            {
                if (AmountQuantity is not null)
                {
                    return AmountQuantity;
                }
        
                if (AmountString is not null)
                {
                    return AmountString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    AmountQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AmountString = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? DefiningSubstanceCodeableConcept { get; set; }
        public object? DefiningSubstance    
        {
            get
            {
                if (DefiningSubstanceCodeableConcept is not null)
                {
                    return DefiningSubstanceCodeableConcept;
                }
        
                if (DefiningSubstanceReference is not null)
                {
                    return DefiningSubstanceReference;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DefiningSubstanceCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    DefiningSubstanceReference = (Base.ResourceReference)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? DefiningSubstanceReference { get; set; }
        public Base.Quantity? AmountQuantity { get; set; }
        public string? AmountString { get; set; }
        public Base.CodeableConcept? Code { get; set; }
        public string? Parameters { get; set; }
    }

    public class SubstanceSpecification_Name_Official : BackboneElement
    {
        public string? Date { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public Base.CodeableConcept? Authority { get; set; }
    }

    public class SubstanceSpecification_Name_Synonym_Official : BackboneElement
    {
        public string? Date { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public Base.CodeableConcept? Authority { get; set; }
    }

    public class SubstanceSpecification_Name_Synonym : BackboneElement
    {
        public SubstanceSpecification_Name_Synonym_Official[]? Official { get; set; }
        public Base.CodeableConcept[]? Jurisdiction { get; set; }
        public required string Name { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference[]? Source { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public Base.CodeableConcept[]? Language { get; set; }
        public string[]? Synonym { get; set; }
        public string[]? Translation { get; set; }
        public bool? Preferred { get; set; }
        public Base.CodeableConcept[]? Domain { get; set; }
    }

    public class SubstanceSpecification_Name_Translation_Official : BackboneElement
    {
        public string? Date { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public Base.CodeableConcept? Authority { get; set; }
    }

    public class SubstanceSpecification_Name_Translation : BackboneElement
    {
        public SubstanceSpecification_Name_Translation_Official[]? Official { get; set; }
        public Base.CodeableConcept[]? Jurisdiction { get; set; }
        public required string Name { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference[]? Source { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public Base.CodeableConcept[]? Language { get; set; }
        public string[]? Synonym { get; set; }
        public string[]? Translation { get; set; }
        public bool? Preferred { get; set; }
        public Base.CodeableConcept[]? Domain { get; set; }
    }

    public class SubstanceSpecification_Name : BackboneElement
    {
        public SubstanceSpecification_Name_Official[]? Official { get; set; }
        public Base.CodeableConcept[]? Jurisdiction { get; set; }
        public required string Name { get; set; }
        public Base.CodeableConcept? Type { get; set; }
        public Base.ResourceReference[]? Source { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public Base.CodeableConcept[]? Language { get; set; }
        public SubstanceSpecification_Name_Synonym[]? Synonym { get; set; }
        public SubstanceSpecification_Name_Translation[]? Translation { get; set; }
        public bool? Preferred { get; set; }
        public Base.CodeableConcept[]? Domain { get; set; }
    }

    public class SubstanceSpecification_Relationship : BackboneElement
    {
        public object? Amount    
        {
            get
            {
                if (AmountRatio is not null)
                {
                    return AmountRatio;
                }
        
                if (AmountQuantity is not null)
                {
                    return AmountQuantity;
                }
        
                if (AmountString is not null)
                {
                    return AmountString;
                }
        
                if (AmountRange is not null)
                {
                    return AmountRange;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    AmountRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    AmountQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AmountString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    AmountRange = (Base.Range)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.CodeableConcept? SubstanceCodeableConcept { get; set; }
        public Base.Ratio? AmountRatioLowLimit { get; set; }
        public Base.CodeableConcept? AmountType { get; set; }
        public Base.CodeableConcept? Relationship { get; set; }
        public Base.ResourceReference[]? Source { get; set; }
        public Base.ResourceReference? SubstanceReference { get; set; }
        public Base.Ratio? AmountRatio { get; set; }
        public object? Substance    
        {
            get
            {
                if (SubstanceCodeableConcept is not null)
                {
                    return SubstanceCodeableConcept;
                }
        
                if (SubstanceReference is not null)
                {
                    return SubstanceReference;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    SubstanceCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    SubstanceReference = (Base.ResourceReference)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Quantity? AmountQuantity { get; set; }
        public string? AmountString { get; set; }
        public bool? IsDefining { get; set; }
        public Base.Range? AmountRange { get; set; }
    }

    public class SubstanceSpecification_Moiety : BackboneElement
    {
        public Base.CodeableConcept? Role { get; set; }
        public object? Amount    
        {
            get
            {
                if (AmountQuantity is not null)
                {
                    return AmountQuantity;
                }
        
                if (AmountString is not null)
                {
                    return AmountString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    AmountQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AmountString = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? Name { get; set; }
        public string? MolecularFormula { get; set; }
        public Base.Quantity? AmountQuantity { get; set; }
        public string? AmountString { get; set; }
        public Base.CodeableConcept? OpticalActivity { get; set; }
        public Base.Identifier? Identifier { get; set; }
        public Base.CodeableConcept? Stereochemistry { get; set; }
    }

    public class SubstanceSpecification_Structure_Isotope_MolecularWeight : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.Quantity? Amount { get; set; }
        public Base.CodeableConcept? Method { get; set; }
    }

    public class SubstanceSpecification_Structure_Isotope : BackboneElement
    {
        public Base.CodeableConcept? Name { get; set; }
        public Base.Quantity? HalfLife { get; set; }
        public Base.Identifier? Identifier { get; set; }
        public Base.CodeableConcept? Substitution { get; set; }
        public SubstanceSpecification_Structure_Isotope_MolecularWeight? MolecularWeight { get; set; }
    }

    public class SubstanceSpecification_Structure_Representation : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.Attachment? Attachment { get; set; }
        public string? Representation { get; set; }
    }

    public class SubstanceSpecification_Structure_MolecularWeight : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.Quantity? Amount { get; set; }
        public Base.CodeableConcept? Method { get; set; }
    }

    public class SubstanceSpecification_Structure : BackboneElement
    {
        public Base.ResourceReference[]? Source { get; set; }
        public SubstanceSpecification_Structure_Isotope[]? Isotope { get; set; }
        public SubstanceSpecification_Structure_Representation[]? Representation { get; set; }
        public SubstanceSpecification_Structure_MolecularWeight? MolecularWeight { get; set; }
        public Base.CodeableConcept? OpticalActivity { get; set; }
        public Base.CodeableConcept? Stereochemistry { get; set; }
        public string? MolecularFormula { get; set; }
        public string? MolecularFormulaByMoiety { get; set; }
    }

    public class SubstanceSpecification_Code : BackboneElement
    {
        public Base.CodeableConcept? Code { get; set; }
        public Base.ResourceReference[]? Source { get; set; }
        public Base.CodeableConcept? Status { get; set; }
        public string? Comment { get; set; }
        public string? StatusDate { get; set; }
    }

    public class SubstanceSpecification_MolecularWeight : BackboneElement
    {
        public Base.CodeableConcept? Type { get; set; }
        public Base.Quantity? Amount { get; set; }
        public Base.CodeableConcept? Method { get; set; }
    }
}