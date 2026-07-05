from datetime import datetime, timezone

from sqlalchemy import create_engine, UniqueConstraint
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, Session

DB_PATH = "sqlite:///easycompra.db"
engine = create_engine(DB_PATH)


class Base(DeclarativeBase):
    pass


class Product(Base):
    __tablename__ = "products"
    __table_args__ = (UniqueConstraint("supermarket", "external_id", name="uq_supermarket_product"),)

    id: Mapped[int] = mapped_column(primary_key=True)
    supermarket: Mapped[str] = mapped_column(index=True)
    external_id: Mapped[str]
    name: Mapped[str]
    brand: Mapped[str | None]
    photo_url: Mapped[str | None]
    unit_price: Mapped[float | None]
    reference_price: Mapped[float | None]
    reference_format: Mapped[str | None]
    ean: Mapped[str | None]
    ingredients: Mapped[str | None]
    allergens: Mapped[str | None]
    contains_nata: Mapped[bool] = mapped_column(default=False)
    nutriscore_grade: Mapped[str | None]
    energy_kcal_100g: Mapped[float | None]
    fat_100g: Mapped[float | None]
    saturated_fat_100g: Mapped[float | None]
    carbohydrates_100g: Mapped[float | None]
    sugars_100g: Mapped[float | None]
    proteins_100g: Mapped[float | None]
    salt_100g: Mapped[float | None]
    share_url: Mapped[str | None]
    updated_at: Mapped[datetime] = mapped_column(default=lambda: datetime.now(timezone.utc))


def init_db() -> None:
    Base.metadata.create_all(engine)


def upsert_product(session: Session, product: dict) -> None:
    existing = (
        session.query(Product)
        .filter_by(supermarket=product["supermarket"], external_id=product["external_id"])
        .one_or_none()
    )
    product = {**product, "updated_at": datetime.now(timezone.utc)}
    if existing:
        for key, value in product.items():
            setattr(existing, key, value)
    else:
        session.add(Product(**product))
